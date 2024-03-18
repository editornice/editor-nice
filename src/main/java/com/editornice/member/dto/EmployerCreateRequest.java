package com.editornice.member.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class EmployerCreateRequest {
    //@NotBlank
    //@Email(message="이메일 주소 양식을 확인해주세요")
    private String email;
    //@NotBlank(message = "휴대폰번호를 입력해주세요")
    //@Pattern(regexp = "/^\\d{3}-\\d{3,4}-\\d{4}$/;")
    private String tel;
    //@NotBlank(message = "회사설명을 등록해주세요")
    private String content;



}
