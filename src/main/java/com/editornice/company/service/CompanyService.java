package com.editornice.company.service;

import com.editornice.company.domain.Company;
import com.editornice.company.dto.request.CompanyCreateRequest;
import com.editornice.company.repository.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class CompanyService {

    private final CompanyRepository companyRepository;

    public Long save(CompanyCreateRequest createRequest) {
        Company company = createRequest.toEntity();
        return companyRepository.save(company).getId();
    }
}
