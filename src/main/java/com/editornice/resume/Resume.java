package com.editornice.resume;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Getter
public class Resume {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long jobSeekerId;
    private String title;
    private String content;
    private String career;
    private String desiredSalary;
    private String payMethod;
    private String visibility;
    private Date created_date;
    private Date updated_date;
}
