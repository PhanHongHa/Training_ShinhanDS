package com.example.demoThymeleaf;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "item")
public class Item {
    @Id
    private long id;
    private String name;
}
