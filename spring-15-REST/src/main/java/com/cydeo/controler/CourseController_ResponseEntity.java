package com.cydeo.controler;

import com.cydeo.dto.CourseDTO;
import com.cydeo.service.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // Spring MVC @Controller+@ResponseBody
@RequestMapping("/courses/api/v2")//v1 - v2 - v3 -> is coming from version
public class CourseController_ResponseEntity { // If we create class and add annotation @RestController we are Developing an API

    private final CourseService courseService;


    public CourseController_ResponseEntity(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping   //ResponseEntity is Generic <accept something> use for modified something: status,header (key and value)
    public ResponseEntity<List<CourseDTO>> getAllCourses(){ // responsibility of this method is to return al, the courses of DTO
        return ResponseEntity // generic class that is accepted something
                .status(HttpStatus.ACCEPTED)
                .header("Version","Cydeo.V2") // header are key and value (map)
                .header("Operation","Get List")
                .body(courseService.getCourses()); // this is DATA
    }

    @GetMapping("{id}")
    public ResponseEntity<CourseDTO> getCourseById(@PathVariable("id") long courseId){
        return ResponseEntity
                .ok(courseService.getCourseById(courseId));
    }
    @GetMapping("/category/{name}")
    public ResponseEntity<List<CourseDTO>> getCoursesByCategory(@PathVariable("name") String category){
        return ResponseEntity.ok(courseService.getCoursesByCategory(category));
    }

    @PostMapping //@RequestBody -> is used  to capture the Jason Object  as we can see example below from API -> {
//        "id": 6,
//                "name": " Application Development",
//                "category": "Spring",
//                "rating": 8,
//                "description": "Spring Boot "
//}
    public ResponseEntity<CourseDTO> createCourse(@RequestBody CourseDTO course){

        return ResponseEntity.status(HttpStatus.CREATED)
                .header("Operation","Create")
                .body(courseService.createCourse(course));

    }
     @DeleteMapping("{id}")
    public ResponseEntity<Void>deleteCourseById(@PathVariable("id") Long courseId){
        courseService.deleteCourseById(courseId);
        return ResponseEntity.noContent().build();
    }
    @PostMapping("{id}")
    public ResponseEntity<Void>updateCourse(@PathVariable("id") Long courseId, @RequestBody CourseDTO course){
        courseService.updateCourse(courseId,course);
        return ResponseEntity.noContent().build();
    }
}
