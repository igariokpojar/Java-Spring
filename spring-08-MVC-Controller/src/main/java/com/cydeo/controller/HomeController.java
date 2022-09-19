package com.cydeo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

//    @RequestMapping("/home")
//    // this method need to return the view
//    public String home() { // which en point? www.amazon.com/register
//        return "home.html";
//    }

    @RequestMapping({"/banana", "/orange"}) // if you do not specify, it will be added as default to initial page localhost:8080
    public String getHomePage(){
        return "home.html";
    }

}
