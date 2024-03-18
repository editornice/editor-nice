package com.editornice.jobseeker.service;

import com.editornice.jobseeker.domain.JobSeeker;
import com.editornice.jobseeker.repository.JobSeekerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class JobSeekerService {

    private final JobSeekerRepository jobseekerRepository;

    public JobSeeker findById(Long jobSeekerId){
        JobSeeker jobSeeker = jobseekerRepository.findById(jobSeekerId)
                .orElseThrow(() -> new RuntimeException("존재하지 않는 구인자입니다."));
        return jobSeeker;
    }

}
