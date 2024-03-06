package com.editornice.company.service;

import com.editornice.company.dto.request.CompanyCreateRequest;
import com.editornice.company.repository.CompanyRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
@Transactional
class CompanyServiceTest {

    @Autowired
    private CompanyService companyService;

    @Autowired
    private CompanyRepository companyRepository;

    @Test
    @DisplayName("업체가 등록된 뒤 companyId를 반환한다.")
    void save() {
        // given
        CompanyCreateRequest companyCreateRequest = new CompanyCreateRequest(
                "회사A",
                "홍길동",
                "123456789",
                "경기도수원시",
                LocalDate.of(2023, 3, 6)
        );

        // when
        Long companyId = companyService.save(companyCreateRequest);

        // then
        assertThat(companyId).isEqualTo(1L);
    }

    @Test
    @DisplayName("이미 등록된 업체일 경우 기존 업체의 companyId를 반환하고, 중복 등록을 하지 않는다.")
    void save_duplicate() {
        // given
        CompanyCreateRequest companyCreateRequest = new CompanyCreateRequest(
                "회사A",
                "홍길동",
                "123456789",
                "경기도수원시",
                LocalDate.of(2023, 3, 6)
        );

        // when
        Long companyId1 = companyService.save(companyCreateRequest);
        Long companyId2 = companyService.save(companyCreateRequest);

        // then
        long count = companyRepository.count();

        assertThat(companyId1).isEqualTo(1L);
        assertThat(companyId2).isEqualTo(1L);
        assertThat(count).isEqualTo(1);
    }
}