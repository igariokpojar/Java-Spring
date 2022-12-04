package com.cydeo.client;

import com.cydeo.dto.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
// please add annotation @EnableFeignClients on your runner class before create FeignClient
@FeignClient(url = "https://jsonplaceholder.typicode.com",name = "USER-CLIENT") // we have two parameters inside, the URI needs to be consumed , name = can be any name, in microservice will make senses;
public interface UserClient {
    /*
    @FeignClient annotation is used to tell tha application that this Interface
    is something that I need to use with Open-fain, so that I can send 3rd party APIs some request.
     */

    @GetMapping("/users") // this method is consuming from the third party
    List<User> getUsers(); // whenever we call this method everywhere in the application
    // it will hit this end point "https://jsonplaceholder.typicode.com" with the @GetMapping,
    // Json is going to be assigned to your DTO
}
