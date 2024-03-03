package com.editornice.comment;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Entity
@Getter
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long boardId;
    private long reparent;//부모댓글
    @NotBlank(message="댓글을 작성해주세요.")
    private String content;
    private Date createdDate;
    private Date updatedDate;

}
