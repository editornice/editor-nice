package com.editornice.jobseeker;

import com.editornice.jobseeker.domain.JobSeeker;
import com.editornice.jobseeker.dto.JobSeekerCreateRequest;
import com.editornice.jobseeker.service.JobSeekerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class JobSeekerController {


    private final JobSeekerService jobSeekerService;

    @PostMapping("/members/job-seeker")
    public ResponseEntity<JobSeeker> saveJobSeeker(HttpServletRequest request, @RequestBody @Valid JobSeekerCreateRequest jobSeekerCreateRequest){
        //HttpSession session = request.getSession();
        //System.out.println(session.getServletContext()+"세션");
        //Member member = (Member)session.getAttribute("member");
        //멤버 못가져옴
        jobSeekerService.saveJobSeeker(jobSeekerCreateRequest, 1L);

        return ResponseEntity.noContent().build();
    }
}
