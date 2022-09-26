package com.cydeo.controller;

import com.cydeo.bootstrap.DataGenerator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/student")
public class StudentController {

    @RequestMapping("/register") //localhost:8080/student/register
    public String register(Model model){ // we add this annotation because we want one class to call each method

        model.addAttribute("students", DataGenerator.createStudent());  // all the students describe in DG

        return "student/register";
    }

    @RequestMapping("/welcome") //localhost:8080/student/welcome?name=Ozzy
    public String welcome(){


        return "student/welcome";
    }
}
