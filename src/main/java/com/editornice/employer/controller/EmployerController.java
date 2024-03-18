package com.editornice.employer.controller;

import com.editornice.employer.dto.EmployerCreateRequest;
import com.editornice.employer.dto.response.EmployerCompanyResponse;
import com.editornice.employer.service.EmployerService;
import com.editornice.jobseeker.domain.JobSeeker;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;


@RestController
@RequiredArgsConstructor
public class EmployerController {

    private final EmployerService employerService;

    @PostMapping("/mypage/company")
    public ResponseEntity<EmployerCompanyResponse> getCompany() {
        // TODO : 추후 유저 정보 받으면 수정
        EmployerCompanyResponse employerCompanyResponse = employerService.getEmployerCompany(1L);
        return ResponseEntity.ok().body(employerCompanyResponse);
    }
    @PostMapping("/members/employer")
    public ResponseEntity<JobSeeker> saveEmployer(HttpServletRequest request, @RequestBody @Valid EmployerCreateRequest employerCreateRequest){
        //HttpSession session = request.getSession();
        //System.out.println(session.getServletContext()+"세션");
        //Member member = (Member)session.getAttribute("member");
        //멤버 못가져옴
        employerService.saveEmployer(employerCreateRequest, 1L);

        return ResponseEntity.noContent().build();
    }
}