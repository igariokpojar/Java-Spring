package com.cydeo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
@RequestMapping("/cydeo")
public class Consume_RestTemplate {

    private final RestTemplate restTemplate;
    private final String URI = "https://jsonplaceholder.typicode.com/users";

    public Consume_RestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
}
