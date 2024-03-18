package com.editornice.jobseeker.service;

import com.editornice.jobseeker.domain.JobSeeker;
import com.editornice.jobseeker.dto.JobSeekerCreateRequest;
import com.editornice.jobseeker.repository.JobSeekerRepository;
import com.editornice.member.domain.Member;
import com.editornice.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class JobSeekerService {
    private final MemberRepository memberRepository;
    private final JobSeekerRepository jobSeekerRepository;

    public Long saveJobSeeker(JobSeekerCreateRequest jobSeekerCreateRequest, Long id){
        JobSeeker jobSeeker = jobSeekerCreateRequest.toEntity();
        Member member = memberRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("존재하지않는 회원입니다"));

        member.setEmail(jobSeekerCreateRequest.getEmail());

        member.setTel(jobSeekerCreateRequest.getTel());

        member.setProfileImg(jobSeekerCreateRequest.getProfileImg());
        jobSeeker.setMember(member);
        JobSeeker save = jobSeekerRepository.save(jobSeeker);
        return memberRepository.findById(id)
                .map(Member::getId)
                .orElseGet(()->jobSeekerRepository.save(jobSeeker).getMember_id());


    }
}
