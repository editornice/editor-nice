package com.editornice.wishlist.domain;

import com.editornice.employer.domain.Employer;
import com.editornice.jobseeker.domain.JobSeeker;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class WishList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "employer_id")
    private Employer employer;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "job_seeker_id")
    private JobSeeker jobSeeker;
}
