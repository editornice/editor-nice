package com.editornice.employer.dto.response;

import com.editornice.company.domain.Company;
import com.editornice.employer.domain.Employer;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Builder
public class EmployerCompanyResponse {

    private String name;
    private String ceoName;
    private String businessNum;
    private String address;
    private LocalDate openingDate;
    private String content;
    private String img;

    public static EmployerCompanyResponse of(Employer employer) {
        Company company = employer.getCompany();

        return EmployerCompanyResponse.builder()
                .name(company.getName())
                .ceoName(company.getCeoName())
                .businessNum(company.getBusinessNum())
                .address(company.getAddress())
                .openingDate(company.getOpeningDate())
                .content(employer.getContent())
                .build();
    }
}
