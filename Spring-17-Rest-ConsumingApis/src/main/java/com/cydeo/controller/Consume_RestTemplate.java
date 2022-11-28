package com.cydeo.controller;

import com.cydeo.dto.User;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;


@RestController
@RequestMapping("/cydeo")
public class Consume_RestTemplate {

    /* we learn how to consume API by using RestTemplate,
    for the RestTemplate way we are using RestTemplate class we create a bean in the Runner class,
     and inside this class we can use 3 different methods to consume: getForEntity, getForObject, exchange

*/
    private final RestTemplate restTemplate; // is coming with Spring Framework and we creat a @Bean in Runner Class
    private final String URI = "https://jsonplaceholder.typicode.com/users"; // we will consume this URI/ is coming all User info the Json output

    public Consume_RestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    // create own methods that API is going to consume it
    @GetMapping
    public ResponseEntity<User[]> readAllUsers() {
        //getForEntity -> give me the URL and show me the DTO
        return restTemplate.getForEntity(URI, User[].class);

        //getForEntity method -> we are using if we have DTO so when we consume the API that output is going to be mapped to our DTO,
        // and we are going to see output what ever my DTO has it
    }

    @GetMapping("{id}") // base in the "id" show me the certain user
    public Object readUser(@PathVariable("id") Integer id) {

        String URL = URI + "/{id}";
        // give me the URL and I will give you everything
        return restTemplate.getForObject(URL, Object.class, id);

        //getForObject method -> we don't have DTO it is just taking from third party API,
        // and what ever Json result output is we see in our end point
    }

    @GetMapping("/test")
    public ResponseEntity<Object> consumePostFromDummyApi() {
 // in this method we set the headers
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.set("app-id", "6298ebfecd0551211fce37a6");

        HttpEntity<String> entity = new HttpEntity<>(headers);

        return restTemplate.exchange("https://dummyapi.io/data/v1/user?limit=10", HttpMethod.GET,entity,Object.class);


    }
}
