package com.cydeo.dto;

import com.cydeo.enums.UserRole;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true) // preventing the User to send the unknown property
public class UserDTO {

    private String email;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY) // some field of json property
    private String password;

    private String username;
    private UserRole role;

    @JsonManagedReference // // This field is going to be serialized(we are going to see the Object to be converted to Json account
    private AccountDTO account;

}
