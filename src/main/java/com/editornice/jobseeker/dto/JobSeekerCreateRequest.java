package com.editornice.jobseeker.dto;

import com.editornice.jobseeker.domain.JobSeeker;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class JobSeekerCreateRequest {
    @NotBlank
    @Email(message="이메일 주소 양식을 확인해주세요")
    private String email;
    @NotBlank(message = "휴대폰번호를 입력해주세요")
    //@Pattern(regexp = "/^\\d{3}-\\d{3,4}-\\d{4}$/")
    private String tel;
    @NotBlank(message = "프로필이미지를 등록해주세요")
    private String profileImg;

    @NotBlank(message = "생년월일을 입력해주세요")
    //@Pattern(regexp = "/^(19|20)\\d{2}-(0[1-9]|1[0-2])-([0-2][1-9]|3[01])$/",message = "YYYY-MM-DD형식입니다")
    private String dateOfBirth;

    public JobSeeker toEntity() {
        return JobSeeker.builder()
                .dateOfBirth(dateOfBirth)
                .build();
    }

}
