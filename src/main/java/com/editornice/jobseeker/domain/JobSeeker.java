package com.editornice.jobseeker.domain;

import com.editornice.member.domain.Member;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class JobSeeker {

    @Id
    private Long member_id;

    @MapsId
    @OneToOne
    @JoinColumn(name = "member_Id")
    private Member member;

    private String dateOfBirth;

    private String averageRating;

    private String ratingCount;

}
