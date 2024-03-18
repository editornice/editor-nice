package com.editornice.jobseeker.controller;

import com.editornice.jobseeker.domain.JobSeeker;
import com.editornice.jobseeker.service.JobSeekerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
public class JobSeekerController {

    private final JobSeekerService jobseekerService;

    /**
     * 프로필 수정
     * @param id
     * @return ResponseEntity
     */
    @GetMapping("/members/job-seeker")
    public ResponseEntity<JobSeeker> update(long id) {

        JobSeeker jobSeeker = jobseekerService.findById(id);
        return ResponseEntity.ok().body(jobSeeker);
    }
}