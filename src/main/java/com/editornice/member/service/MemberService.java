package com.editornice.member.service;

import com.editornice.jobseeker.domain.JobSeeker;
import com.editornice.member.domain.Member;
import com.editornice.member.dto.JobSeekerCreateRequest;
import com.editornice.member.repository.JobSeekerRepository;
import com.editornice.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final JobSeekerRepository jobSeekerRepository;
    private final MemberRepository memberRepository;


    public Long save(JobSeekerCreateRequest jobSeekerCreateRequest, Long id){
        JobSeeker jobSeeker = jobSeekerCreateRequest.toEntity();
        Member member1 = memberRepository.findById(id).orElseThrow(()-> new RuntimeException("존재하지않는 회원입니다"));
        //공통 member 조회후 업데이트
        member1.setEmail(jobSeekerCreateRequest.getEmail());
        member1.setTel(jobSeekerCreateRequest.getTel());
        member1.setProfileImg(jobSeekerCreateRequest.getProfileImg());
        jobSeeker.setMember(member1);
        return memberRepository.findById(id)
                .map(Member::getId)
                .orElseGet(()->jobSeekerRepository.save(jobSeeker).getMember_id());
    }


}
