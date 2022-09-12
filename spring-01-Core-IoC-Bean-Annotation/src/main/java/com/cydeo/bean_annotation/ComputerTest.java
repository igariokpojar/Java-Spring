package com.cydeo.bean_annotation;

import com.cydeo.bean_annotation.casefactory.Case;
import com.cydeo.bean_annotation.casefactory.DellCase;
import com.cydeo.bean_annotation.config.ComputerConfig;
import com.cydeo.bean_annotation.config.RandomConfig;
import com.cydeo.bean_annotation.monitorfactory.Monitor;
import com.cydeo.bean_annotation.monitorfactory.SonyMonitor;
import com.cydeo.bean_annotation.motherboardfactory.AsusMotherboard;
import com.cydeo.bean_annotation.motherboardfactory.Motherboard;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ComputerTest {
    public static void main(String[] args) {

        // Creating container by using Application Context
        ApplicationContext container = new AnnotationConfigApplicationContext(ComputerConfig.class, RandomConfig.class); //  we create container and add configuration

        // Creating container by using BeanFactory
        BeanFactory context = new AnnotationConfigApplicationContext();

        System.out.println("************Retrieving the beans******************");

        SonyMonitor sony = container.getBean(SonyMonitor.class);
        DellCase dell = container.getBean(DellCase.class);
        AsusMotherboard asus = container.getBean(AsusMotherboard.class);

        PC myPc = new PC(dell,sony,asus);

        myPc.powerUp();

        dell.pressPowerButton();

     //  Monitor theMonitor = container.getBean(Monitor.class); // give one object that contains Monitor class
     //  SonyMonitor sonyMonitor = container.getBean(SonyMonitor.class); // hey container give me Bean that belongs to SonyMonitor class
      //  Motherboard theMotherboard = container.getBean(Motherboard.class);
      //  Case theCase = container.getBean(Case.class);

       // Inversion of control Principle
      //  PC myPc = new PC(theCase,sonyMonitor,theMotherboard);
       // myPc.powerUp();

        System.out.println("***************Multiple Objects****************");

        System.out.println("************Multiple Objects******************");

        Monitor theMonitor2 = container.getBean("monitorSony", Monitor.class);  //DEFAULT BEAN NAME
        Monitor theMonitor3 = container.getBean("sony", Monitor.class);  //CUSTOM BEAN NAME
        Monitor theMonitor4 = container.getBean( Monitor.class);  //@Primary
    }
}
