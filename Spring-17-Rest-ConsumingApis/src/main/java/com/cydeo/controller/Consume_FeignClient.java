package com.cydeo.controller;

import com.cydeo.client.EmployeeClient;
import com.cydeo.client.UserClient;
import com.cydeo.dto.ResponseWrapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Consume_FeignClient { // please add annotation @EnableFeignClients on your runner class

    private final UserClient userClient;
    private final EmployeeClient employeeClient;

    public Consume_FeignClient(UserClient userClient, EmployeeClient employeeClient) {
        this.userClient = userClient;
        this.employeeClient = employeeClient;
    }

    @GetMapping("/api/v1/users")
    public ResponseEntity<ResponseWrapper>getUsers(){ // this method is going to consume what we have inside the getUser ->(url = "https://jsonplaceholder.typicode.com",name = "USER-CLIENT")
// ResponseEntity is a generic that takes parameters inside that's why we have ResponseWrapper os Object DTO return as a body in Response
        return ResponseEntity
                .ok(new ResponseWrapper("UserList Retrieved",userClient.getUsers()));
    }
    @GetMapping("/api/v1/employee")
    public ResponseEntity<ResponseWrapper>getEmployee(){

        return ResponseEntity.ok(new ResponseWrapper("Employee Retrieved",employeeClient.getEmployee("6298ebfecd0551211fce37a6")));
    }
}
