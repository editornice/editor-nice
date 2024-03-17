package com.editornice.jobseeker.repository;

import com.editornice.jobseeker.domain.JobSeeker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobSeekerRepository extends JpaRepository<JobSeeker, Long> {
}
