package com.editornice.company.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private String ceoName;

    @Column(nullable = false, unique = true)
    private String businessNum;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private LocalDate openingDate;

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createdDate;

    @LastModifiedDate
    private LocalDateTime updatedDate;

    @Builder
    public Company(String name, String ceoName, String businessNum, String address, LocalDate openingDate) {
        this.name = name;
        this.ceoName = ceoName;
        this.businessNum = businessNum;
        this.address = address;
        this.openingDate = openingDate;
    }


    public Company(Long id, String name, String ceoName, String businessNum, String address, LocalDate openingDate) {
        this.id = id;
        this.name = name;
        this.ceoName = ceoName;
        this.businessNum = businessNum;
        this.address = address;
        this.openingDate = openingDate;
    }

}
