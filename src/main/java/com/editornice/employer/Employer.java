package com.editornice.employer;

import lombok.Getter;

import javax.persistence.Entity;

@Entity
@Getter
public class Employer {
    private long memberId;
    private long companyId;
    private String content;
    private String img;
}
