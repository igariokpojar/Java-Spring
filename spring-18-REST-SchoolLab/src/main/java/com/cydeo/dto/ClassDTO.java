
package com.cydeo.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)// do not include NULL fields.
public class ClassDTO {

    @JsonIgnore
    private Long id; // id is an auto increment field/ is unique in DB, so we are not going to send it.

    private String name;
    private Integer year;

    private CourseDTO course;

    private TeacherDTO teacher;

}