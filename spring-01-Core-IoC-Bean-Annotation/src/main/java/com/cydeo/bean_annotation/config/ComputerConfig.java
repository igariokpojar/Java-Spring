package com.cydeo.bean_annotation.config;

import com.cydeo.bean_annotation.casefactory.Case;
import com.cydeo.bean_annotation.casefactory.DellCase;
import com.cydeo.bean_annotation.monitorfactory.Monitor;
import com.cydeo.bean_annotation.monitorfactory.SonyMonitor;
import com.cydeo.bean_annotation.motherboardfactory.AsusMotherboard;
import com.cydeo.bean_annotation.motherboardfactory.Motherboard;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class ComputerConfig { // defined a class annotation with @Configuration


    @Bean(name = "sony")
    public Monitor monitorSony() { // create a method  that return an Object  with @Bean annotation
        return new SonyMonitor("25 inch Beats", "Sony", 25); // Monitor Object = new Monitor ==> Polymorphism
    }

    @Bean
    @Primary
    public Monitor monitorAcer() { // create a method with @Bean annotation
        return new SonyMonitor("23 inch Beats", "Acer", 23); // Monitor abc = new Monitor == Polymorphism
    }

    @Bean
    public Case caseDell() {
        return new DellCase("220B", "Dell", "240");
    }

    @Bean
    public Motherboard motherboardAsus() {
        return new AsusMotherboard("BJ-200", "Asus", 4, 6, "v2.44");
    }
}


