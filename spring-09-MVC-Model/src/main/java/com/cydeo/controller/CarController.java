package com.cydeo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
//localhost:8080/info?make=Honda
public class CarController {
    @RequestMapping("/info")
    // this part is for creating the URL
    public String carInfo(@RequestParam String make, Model model) {
        model.addAttribute("make", make);

        return "car/car-info";
    }
    //localhost:8080/info2 (KIA)
    @RequestMapping("/info2")  // required = false  .. means that  we may have some parameters, or we can leave it empty
    public String carInfo2(@RequestParam(value = "make", required = false, defaultValue = "KIA") String make, Model model) {
        model.addAttribute("make", make);        //defaultValue = "KIA" if you don't put anything by default is going to assign this value

        return "car/car-info";

    }
    //localhost:8080/info3?make=Honda&year=2015
    @RequestMapping("/info3")
    public String carInfo3(@RequestParam String make,@RequestParam int year, Model model) {
        model.addAttribute("make", make);
        model.addAttribute("year",year);

        return "car/car-info";

    }
    @RequestMapping("/info/{make}/{year}") // localhost:8080/info/honda/2015
    // @PathVariable- is another way to pass values to URL
    // @PathVariable are end points, but they are non-static variable (flexible)
    public String getCarInfo(@PathVariable String make,@PathVariable String year){

        System.out.println(make);
        System.out.println(year);


        return "car/car-info";

    }
}
