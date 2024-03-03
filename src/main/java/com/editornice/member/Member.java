package com.editornice.member;

import lombok.Builder;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Getter
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotBlank(message = "이메일을 입력해주세요.")
    @Email(message = "이메일 형식을 맞춰주세요.")
    private String email;
    @NotBlank(message = "닉네임을 입력해주세요.")
    @Size(min = 2, max = 8, message = "닉네임을 2~8자 사이로 입력해주세요.")
    private String nickname;
    @NotBlank(message="전화번호는 필수 항목입니다.")
    private String tel;
    private String profileImg;
    private String snsType;//enum으로 해야할꺼같음

    private String accessToken;
    private String level;
    private String dType;
    private Date createdDate;
    private Date updatedDate;



}
