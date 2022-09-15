package com.cydeo.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.List;

@Configuration
@ConfigurationProperties(prefix = "db")
@Data
public class DBConfigData {// we use List because we hava more than one in app properties

    private String username;
    private String password;
    private List<String> type;

}

