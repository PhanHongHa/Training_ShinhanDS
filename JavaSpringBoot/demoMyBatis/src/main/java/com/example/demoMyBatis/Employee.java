package com.example.demoMyBatis;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Table(name = "employee")
public class Employee {

    private long id;
    private String firstName;
    private String lastName;
    private String emailId;
}
