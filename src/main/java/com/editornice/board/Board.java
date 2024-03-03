package com.editornice.board;

import com.editornice.category.Category;
import com.editornice.member.Member;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")

    private Member Member;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")

    private Category category;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;
    @Column(nullable = false)
    private String views;
    @CreatedDate
    private Date createdDate;
    @LastModifiedDate
    private Date updatedDate;
}
