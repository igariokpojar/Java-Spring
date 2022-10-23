package com.cydeo.entity;

import javax.persistence.*;
import java.math.BigDecimal;

@MappedSuperclass // represent this clas for providing relationship for subclasses
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String owner;
    private BigDecimal balance;
    private BigDecimal interestRate;
}
