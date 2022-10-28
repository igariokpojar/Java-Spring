package com.cydeo.repository;

import com.cydeo.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.stream.Stream;

public interface CourseRepository extends JpaRepository<Course,Long> {

    // find all courses by category select * from courses where category = ...
    List<Course>findByCategory(String category);

    // find all courses bu category and all order by entity's by name
    List<Course>findByCategoryOrderByName(String category);

    // checks if a course with the supplied name exist.Return tru if existed, false otherwise

    boolean existsByName(String name);

    // return the count of the courses for the given category

    int countByCategory(String category);

    // find all the curses that start with given courses name String

    List<Course>findByNameStartingWith(String name);

    // find all courses by category and return a stream

    Stream<Course>streamAllByCategory(String category);





}
