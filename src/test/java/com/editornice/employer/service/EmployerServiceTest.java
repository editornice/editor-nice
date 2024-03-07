package com.editornice.employer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@Sql({"/h2-truncate.sql"})
class EmployerServiceTest {

    @Autowired
    private EmployerService employerService;

}