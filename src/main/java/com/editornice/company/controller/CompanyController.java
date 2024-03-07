package com.editornice.company.controller;


import com.editornice.company.dto.request.CompanyCreateRequest;
import com.editornice.company.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class CompanyController {

    private final CompanyService companyService;

    @PostMapping("/company")
    public ResponseEntity<Void> createCompany(
            @RequestBody @Valid CompanyCreateRequest companyCreateRequest
    ) {
        companyService.save(companyCreateRequest);
        return ResponseEntity.noContent().build();
    }
}
