package com.editornice.employer.domain;

import com.editornice.company.domain.Company;
import com.editornice.member.domain.Member;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Employer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long member_id;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private Member member;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "company_id")
    private Company company;

    private String content;

    private String img;

    @Builder
    public Employer(String content) {
        this.content = content;
    }

    public void setMember(Member member) {
        this.member = member;
        this.member_id=member.getId();
    }
}
