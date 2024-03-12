package com.editornice.member.domain;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;

    @Column(nullable = false)
    private String nickname;


    private String tel;

    @Column
    private String profileImg;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private SnsType snsType;


    private String accessToken;


    @Enumerated(EnumType.STRING)
    private Level level;

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createdDate;

    @LastModifiedDate
    private LocalDateTime updatedDate;

    @Builder
    private Member(String nickname, SnsType snsType,Level level){
        this.nickname=nickname;
        this.snsType=snsType;
        this.level=level;

    }



}

