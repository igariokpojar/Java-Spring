package com.cydeo.bean_annotation;

import com.cydeo.bean_annotation.casefactory.Case;
import com.cydeo.bean_annotation.config.ComputerConfig;
import com.cydeo.bean_annotation.config.RandomConfig;
import com.cydeo.bean_annotation.monitorfactory.Monitor;
import com.cydeo.bean_annotation.motherboardfactory.Motherboard;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ComputerTest {
    public static void main(String[] args) {

        ApplicationContext container = new AnnotationConfigApplicationContext(ComputerConfig.class, RandomConfig.class); //  we create container

       Monitor theMonitor = container.getBean(Monitor.class); // give one object that contains Monitor class
        Motherboard theMotherboard = container.getBean(Motherboard.class);
        Case theCase = container.getBean(Case.class);


        PC myPc = new PC(theCase,theMonitor,theMotherboard);
        myPc.powerUp();
    }
}
