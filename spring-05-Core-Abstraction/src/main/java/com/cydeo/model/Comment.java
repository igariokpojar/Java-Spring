package com.cydeo.model;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
public class Comment { // Only fields and no @component to any model classes

    private String author;
    private String text;
}
