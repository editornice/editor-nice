package com.editornice.employer.service;

import com.editornice.global.exception.ErrorCode;
import com.editornice.global.exception.NotFoundException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@Sql({"/h2-truncate.sql"})
class EmployerServiceTest {

    @Autowired
    private EmployerService employerService;

    @Test
    @DisplayName("존재하지 않는 employerId를 입력받으면 예외가 발생한다.")
    void getEmployerCompany_NOT_FOUND_EMPLOYER_ID() {
        // then
        assertThatThrownBy(() -> employerService.getEmployerCompany(100L))
                .isInstanceOf(NotFoundException.class)
                .hasMessageContaining(ErrorCode.NOT_FOUND_EMPLOYER_ID.getMessage());
    }

}