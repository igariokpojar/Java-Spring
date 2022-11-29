package com.cydeo.dto;

import com.cydeo.enums.Status;
import com.fasterxml.jackson.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)// do not include NULL fields.
public class StudentDTO {
    /*
        The @JsonManagedReference and @JsonBackReference annotations can be used to create a JSON structure in a bidirectional way.
         The @JsonManagedReference annotation is a forward reference that includes during the serialization process
         whereas @JsonBackReference annotation is a backreference that omits during the serialization process.
         */
    @JsonIgnore
    private Long id;

    private String firstName;
    private String lastName;
    private String phoneNumber;

    private String email;
    private String username;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    private LocalDate birthday;

    private Status status;

    @JsonManagedReference(value = "student-address-reference")
    private AddressDTO address;

    private ParentDTO parent;

}
