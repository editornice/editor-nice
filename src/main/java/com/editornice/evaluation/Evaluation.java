package com.editornice.evaluation;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Getter
public class Evaluation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long employerId;
    private Long jobSeekerId;
    private String content;
    private String rating;
    private Date createdDate;
    private Date UpdatedDate;

}
