package com.editornice.board;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Entity
@Getter
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long userId;
    private long categoryId;
    @NotBlank(message="제목은 필수 항목입니다.")
    private String title;
    @NotBlank(message="내용은 필수 항목입니다.")
    private String content;
    private String views;
    private Date createdDate;
    private Date updatedDate;
}
