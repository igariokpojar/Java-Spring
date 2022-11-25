package com.cydeo.controller;

import com.cydeo.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Controller
public class StudentController {

    @RequestMapping("/welcome")
    //Model is Interface tha is carrying data to view
    public String homePage(Model model){
           // addAttribute is a method that carrying data to view
        model.addAttribute("name","Cydeo");
        // for catching data to view we are using Template Engine 'THYMELEAF'
        model.addAttribute("course","MVC");

        String subject = "Spring Boot";
        model.addAttribute("subject",subject);

        int studentId = new Random().nextInt();
        model.addAttribute("id",studentId);

        List<Integer> numbers = new ArrayList<>(Arrays.asList(1,47,5,2,8,9));
       // numbers.add(4);
      //  numbers.add(5);
      //  numbers.add(6);
        model.addAttribute("numbers",numbers);

        LocalDate dt = LocalDate.now();
        model.addAttribute("date",dt);

        Student student = new Student(1,"Igariok","Pojar");
        model.addAttribute("student",student);

        return "student/welcome";
    }
}
