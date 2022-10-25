package com.cydeo.entity;

import com.cydeo.enums.UserRole;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@Table(name = "account_details")
public class Account extends BaseEntity{

    private String name;
    private String address;
    private String country;
    private String state;
    private String city;
    private String age;
    private String postalCode;
    @Enumerated(EnumType.STRING)
    private UserRole role;

    @OneToOne(mappedBy = "account") // to drop  foreign key on Account table
    private User user;
}
