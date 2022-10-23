package com.cydeo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.MapKey;

@Entity //
public class Employee {

    @Id // makes is as a primary key
    private int id;
    private String name;

}
