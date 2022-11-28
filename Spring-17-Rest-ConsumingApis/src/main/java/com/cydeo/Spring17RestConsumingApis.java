package com.cydeo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class Spring17RestConsumingApis {

    public static void main(String[] args) {
        SpringApplication.run(Spring17RestConsumingApis.class, args);
    }

    @Bean
    public RestTemplate restTemplate(){ // for using certain methods on different classes/ class is not ours
        return new RestTemplate();
    }
}

