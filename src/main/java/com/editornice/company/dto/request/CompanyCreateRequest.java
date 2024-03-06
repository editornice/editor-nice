package com.editornice.company.dto.request;

import com.editornice.company.domain.Company;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class CompanyCreateRequest {

    @NotBlank(message = "회사명을 입력해주세요.")
    private String name;

    @NotBlank(message = "대표자성명을 입력해주세요.")
    private String ceoName;

    @NotBlank(message = "사업자등록번호를 입력해주세요.")
    private String businessNum;

    @NotBlank(message = "주소를 입력해주세요.")
    private String address;

    @NotNull(message = "개업일자를 입력해주세요.")
    @DateTimeFormat(pattern = "yyyyMMdd")
    private LocalDate openingDate;

    public Company toEntity() {
        return Company.builder()
                .name(name)
                .ceoName(ceoName)
                .businessNum(businessNum)
                .address(address)
                .openingDate(openingDate)
                .build();
    }
}
