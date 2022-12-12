package com.cydeo.annotation;


import org.springframework.stereotype.Component;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/*
Do you know what it means? It means this: I can put this annotation on top of the methods
I'm defining my limits I can say.You can provide more than one
level for your annotation right now. We are going to use it only with method level. Okay.
 */

/*
But what you need to know is when your application is compiled after compile minutes is running.
 It's going to read this annotation in the runtime. Okay, whenever you put okay in the runtime.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface LoggingAnnotation {


}
