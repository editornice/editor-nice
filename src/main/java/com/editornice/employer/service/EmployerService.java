package com.editornice.employer.service;

import com.editornice.employer.domain.Employer;
import com.editornice.employer.dto.response.EmployerCompanyResponse;
import com.editornice.employer.repository.EmployerRepository;
import com.editornice.global.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.editornice.global.exception.ErrorCode.*;

@Service
@RequiredArgsConstructor
@Transactional
public class EmployerService {

    private final EmployerRepository employerRepository;

    @Transactional(readOnly = true)
    public EmployerCompanyResponse getEmployerCompany(Long employerId) {

        Employer employer = employerRepository.findById(employerId)
                .orElseThrow(() -> new NotFoundException(NOT_FOUND_EMPLOYER_ID));

        if (employer.getCompany() == null) {
            throw new RuntimeException("등록된 업체가 존재하지 않습니다.");
        }

        return EmployerCompanyResponse.of(employer);
    }
}
