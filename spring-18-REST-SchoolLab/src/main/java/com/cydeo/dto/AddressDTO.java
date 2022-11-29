package com.cydeo.dto;

import com.cydeo.enums.AddressType;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL) // do not include NULL fields.
public class AddressDTO {

    /*
    The @JsonManagedReference and @JsonBackReference annotations can be used to create a JSON structure in a bidirectional way.
     The @JsonManagedReference annotation is a forward reference that includes during the serialization process
     whereas @JsonBackReference annotation is a backreference that omits during the serialization process.
     */

    @JsonIgnore
    private Long id;

    private String street;
    private String country;
    private String state;
    private String city;
    private String postalCode;


    private AddressType addressType;

    @JsonBackReference(value = "student-address-reference") // defaultReference
    private StudentDTO student;

    @JsonBackReference(value = "parent-address-reference")
    private ParentDTO parent; // defaultReference

    @JsonBackReference(value = "teacher-address-reference")
    private TeacherDTO teacher; // defaultReference


    private Integer currentTemperature; // Weather info, which we will later get it from the 3rd party API

}