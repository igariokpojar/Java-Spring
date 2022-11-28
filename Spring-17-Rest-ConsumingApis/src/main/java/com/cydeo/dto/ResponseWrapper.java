package com.cydeo.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@NoArgsConstructor

// This customized class is going to be Converted by Jackson on Json in the API output
public class ResponseWrapper {
 // every end point in our application is going to show all this attributes or fields
    private boolean success;
    private String message;
    private Integer code;
    private Object data;

 // we created two constr bc by the end we are trying to give to API Object of the ResponseWrapper,
 // how to create Object from the class true the constructor, bc we are going to say newResponseWrapper on method body
    //.body(courseService.getCourses());
    public ResponseWrapper(String message, Object data){
        this.message=message;
        this.data = data;
        this.code = HttpStatus.OK.value();
        this.success=true;
    }

    public ResponseWrapper(String message){
        this.message=message;
        this.code=HttpStatus.OK.value();
        this.success=true;

    }

}
