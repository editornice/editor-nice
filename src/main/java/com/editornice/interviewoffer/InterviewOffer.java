package com.editornice.interviewoffer;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Getter
public class InterviewOffer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long employerId;
    private long jobSeekerId;
    private Date interviewDate;
    private String content;
    private String result;
    private String readStatus;
    private Date createdDate;
    private Date UpdatedDate;

    private Date deletedDate;

}
