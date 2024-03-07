package com.editornice.employer.repository;

import com.editornice.employer.domain.Employer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployerRepository extends JpaRepository<Employer, Long> {
}
