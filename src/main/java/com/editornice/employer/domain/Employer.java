package com.editornice.employer.domain;

import com.editornice.company.domain.Company;
import com.editornice.member.domain.Member;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Employer {

    @Id
    private Long member_id;

    @MapsId
    @OneToOne
    @JoinColumn(name = "member_Id")
    private Member member;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "company_id")
    private Company company;

    private String content;

    private String img;
}
