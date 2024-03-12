package com.editornice.member.controller;

import com.editornice.jobseeker.domain.JobSeeker;
import com.editornice.member.domain.Member;
import com.editornice.member.dto.JobSeekerCreateRequest;
import com.editornice.member.service.MemberService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/members/job-seeker")
    public ResponseEntity<JobSeeker> jobseeker( HttpServletRequest request,@RequestBody @Valid JobSeekerCreateRequest jobSeekerCreateRequest){
        HttpSession session = request.getSession();
        Member member = (Member)session.getAttribute("member");
        memberService.save(jobSeekerCreateRequest,member.getId());
        System.out.println(jobSeekerCreateRequest+"저장");
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/")
    public String main(){
        return "로그인성공";
    }



}
