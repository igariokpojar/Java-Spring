package com.cydeo.entity;

import com.cydeo.enums.Gender;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity // make this class table
@Table(name = "students")// table name

public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "studentFirstName")
    private String firstName;
    @Column(name = "studentLastName")
    private String lastName;
    private String email;

    @Column(columnDefinition = "DATE")
    private LocalDate birthDate;
    @Column(columnDefinition = "TIME")
    private LocalDate birthTime;
    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime birthDateTime;


    @Enumerated(EnumType.STRING)// use String to get value or constant value
    //@Enumerated(EnumType.ORDINAL) is for number
    private Gender gender;

    @Transient // sometimes in the claas you don't want ot show some fields in the table
    private String city;

}
