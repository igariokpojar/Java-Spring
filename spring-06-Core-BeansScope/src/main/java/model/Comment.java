package model;

import lombok.Data;

@Data
public class Comment { // Only fields and no @component to any model classes

    private String author;
    private String text;
}
