package com.editornice.jobseeker.domain;

import com.editornice.member.domain.Member;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

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

    @ColumnDefault("0")
    private int ratingCount;

    /**
     * ex) 3.3 / 5
     */
    private Double averageRating;

}
