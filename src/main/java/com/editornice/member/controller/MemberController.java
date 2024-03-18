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
    public ResponseEntity<JobSeeker> saveJobSeeker( HttpServletRequest request,@RequestBody @Valid JobSeekerCreateRequest jobSeekerCreateRequest){
        //HttpSession session = request.getSession();
        //System.out.println(session.getServletContext()+"세션");
        //Member member = (Member)session.getAttribute("member");
        //멤버 못가져옴
        memberService.save(jobSeekerCreateRequest, 6L);

        return ResponseEntity.noContent().build();
    }

    @PostMapping("/members/employer")
    public ResponseEntity<JobSeeker> saveEmployer( HttpServletRequest request,@RequestBody @Valid JobSeekerCreateRequest jobSeekerCreateRequest){
        HttpSession session = request.getSession();
        System.out.println(session.getServletContext()+"세션");
        Member member = (Member)session.getAttribute("member");
        //멤버 못가져옴
        memberService.saveJobSeeker(jobSeekerCreateRequest, 6L);

        return ResponseEntity.noContent().build();
    }
    @GetMapping("")
    public String main(){
        return "로그인성공";
    }
    @GetMapping("/123")
    public String asd(){
        return "아무페이지";
    }



}
