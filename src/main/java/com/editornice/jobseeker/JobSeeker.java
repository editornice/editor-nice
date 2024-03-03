package com.editornice.jobseeker;

import lombok.Getter;

import javax.persistence.Entity;

@Entity
@Getter
public class JobSeeker {
    private long memberId;
    private String dateOfBirth;
    private String averageRating;
    private String ratingCount;
}
