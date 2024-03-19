package com.editornice.jobseeker.domain;

import com.editornice.member.domain.Member;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class JobSeeker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long member_id;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private Member member;

    private String dateOfBirth;

    @ColumnDefault("0")
    private int ratingCount;

    /**
     * ex) 3.3 / 5
     */
    private Double averageRating;

    @Builder
    public JobSeeker(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setMember(Member member) {
        this.member = member;
        this.member_id=member.getId();
    }
}
