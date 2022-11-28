package com.cydeo.controller;

import com.cydeo.dto.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
@RequestMapping("/cydeo")
public class Consume_RestTemplate {

    private final RestTemplate restTemplate; // is coming with Spring Framework and we creat a Bean in runner for use
    private final String URI = "https://jsonplaceholder.typicode.com/users";

    public Consume_RestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping
    public ResponseEntity<User[]> readAllUsers(){
                          //getForEntity -> give me the URL and show me the DTO
      return  restTemplate.getForEntity(URI, User[].class);
    }

    @GetMapping("{id}")
    public Object readUser(@PathVariable("id") Integer id){

        String URL = URI + "/{id}";
                            // give me the URL and i will give you everything
        return restTemplate.getForObject(URL,Object.class,id);
    }
}
