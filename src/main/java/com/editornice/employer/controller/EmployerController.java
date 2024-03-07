package com.editornice.employer.controller;

import com.editornice.employer.dto.response.EmployerCompanyResponse;
import com.editornice.employer.service.EmployerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


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
}