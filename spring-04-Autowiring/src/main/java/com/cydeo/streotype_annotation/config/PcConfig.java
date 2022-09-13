package com.cydeo.streotype_annotation.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.cydeo") // go to each package and look for the classes with is Annotated whit @Component and ==>
//create a Bean and put on Container and manage it for me

public class PcConfig {


}
