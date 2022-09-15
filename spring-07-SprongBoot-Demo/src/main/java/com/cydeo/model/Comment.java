package com.cydeo.model;

import lombok.Data;

@Data
public class Comment { // no @Component to any model classes

    private String author;
    private String text;
}
