package com.editornice.member.repository;

import com.editornice.employer.domain.Employer;
import com.editornice.jobseeker.domain.JobSeeker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployerRepository extends JpaRepository<Employer,Long> {
}
