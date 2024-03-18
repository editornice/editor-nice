package com.editornice.employer.service;

import com.editornice.employer.domain.Employer;
import com.editornice.employer.dto.EmployerCreateRequest;
import com.editornice.employer.dto.response.EmployerCompanyResponse;
import com.editornice.employer.repository.EmployerRepository;
import com.editornice.member.domain.Member;
import com.editornice.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class EmployerService {

    private final MemberRepository memberRepository;
    private final EmployerRepository employerRepository;

    @Transactional(readOnly = true)
    public EmployerCompanyResponse getEmployerCompany(Long employerId) {
        // TODO : 추후 예외 변경
        Employer employer = employerRepository.findById(employerId)
                .orElseThrow(() -> new RuntimeException("존재하지 않는 구인자입니다."));

        if (employer.getCompany() == null) {
            throw new RuntimeException("등록된 업체가 존재하지 않습니다.");
        }

        return EmployerCompanyResponse.of(employer);
    }

    public Long saveEmployer(EmployerCreateRequest employerCreateRequest, Long id){
        Employer employer = employerCreateRequest.toEntity();
        Member member = memberRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("존재하지않는 회원입니다"));

        member.setEmail(employerCreateRequest.getEmail());

        member.setTel(employerCreateRequest.getTel());

        employer.setMember(member);
        Employer save = employerRepository.save(employer);
        return memberRepository.findById(id)
                .map(Member::getId)
                .orElseGet(()->employerRepository.save(employer).getMember_id());


    }
}
