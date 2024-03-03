package com.editornice.company;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Getter
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String ceoName;
    private String businessNum;
    private String address;

    private Date openingDate;
    private Date updatedDate;
    private Date createdDate;
}
