package com.editornice.jobexperience;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
public class JobExperience {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long resumeId;
    private String companyName;
    private String period;
    private String task;
    private String content;
    private String order;
}
