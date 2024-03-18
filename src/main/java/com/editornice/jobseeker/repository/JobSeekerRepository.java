package com.editornice.jobseeker.repository;

import com.editornice.jobseeker.domain.JobSeeker;
import com.editornice.member.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobSeekerRepository extends JpaRepository<JobSeeker,Long> {
}
