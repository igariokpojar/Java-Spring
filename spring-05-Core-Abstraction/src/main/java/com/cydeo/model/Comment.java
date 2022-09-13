package com.cydeo.model;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
public class Comment { // Only fields

    private String author;
    private String text;
}
