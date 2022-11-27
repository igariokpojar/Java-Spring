package com.cydeo.controler;

import com.cydeo.dto.CourseDTO;
import com.cydeo.service.CourseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController    //"/courses/api/v1" is for make this point unique v1  = version one
@RequestMapping("/courses/api/v1") //localhost:8080/courses -> GET on Postman
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping // we have ready method -> List<CourseDTO> getCourses() on Interface Courses Service
    public List<CourseDTO> getAllCourses(){
        return courseService.getCourses();
    }

    @GetMapping("{id}") // localhost:8080/courses/2
     public CourseDTO getCourseById(@PathVariable ("id") long courseId){
     return courseService.getCourseById(courseId);
     }

     @GetMapping("/category/{name}") // get category by name
    public List<CourseDTO> getCourseByCategory(@PathVariable ("name") String category){
        return courseService.getCoursesByCategory(category);
     }

     @PostMapping //@RequestBody is used to capture the Object from Postman for example we want to post same data then this @RequestBody  is going to capture that data
     public CourseDTO createCourse(@RequestBody CourseDTO course){
      return courseService.createCourse(course);
     }

     @PutMapping("{id}")
     public void updateCourse(@PathVariable("id") long courseId,@RequestBody CourseDTO course){
        courseService.updateCourse(courseId,course);
     }

     @DeleteMapping("{id}")
     public void deleteCourseById(@PathVariable("id") long courseId){
        courseService.deleteCourseById(courseId);
     }

}
