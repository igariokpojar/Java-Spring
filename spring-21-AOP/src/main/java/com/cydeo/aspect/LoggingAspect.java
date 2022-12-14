package com.cydeo.aspect;

import com.cydeo.dto.CourseDTO;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;// slf4j -> logging for Java
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/* Add dependency if you want to use this class
<dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-aop</artifactId>
        </dependency>
 */

@Aspect
@Component
public class LoggingAspect {

    /*
    I will use this class to put some information in the console whenever I use some methods. Okay.
     */


   // You can use this logger variable or field to put some information in Console it. Isn't going to be like system out printLn
          //  for us for now, but later you will see different usages of logger. Okay.
    Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

//    @Pointcut("execution(* com.cydeo.controller.CourseController.*(..))")
//    public void myPointcut() {}

    /*
    We define join points by creating point cuts. Now it is time to create advice
in advice. We are going to put what we need to do. And is it a little before or after?
when my joy point runs?
     */
//I want this method to run whatever we have inside this method before
//any method inside the coursesController
//    @Before("myPointcut()")
//    public void log() {
//        logger.info("Info log..........");
//    }
    /*
    We are running some execution. Okay, we are checking. If the method is executed or not. Okay, that's why we are using execution.
    This part is the return type. Okay, i'm saying that any return type. I'm accepting I am using,
    methods that return anything as my join points, and we need to provide the package, name class name in here,because which methods that
    which methods are going to be. My joy points right? So I need to define those methods.
    So i'm telling this those mountains are going to be inside my controller package and inside my controller class
    and after class, if you put one dot, which means next level is method, right?

     */
//    @Before("execution(* com.cydeo.controller.CourseController.*(..))")
//    public void log() {
//        logger.info("Info log..........");
//    }

//    @Pointcut("execution(* com.cydeo.repository.CourseRepository.findById(*))")//creating point count means what's defined in my join points. Okay.
//    public void courseRepositoryFindByIdPC() {}
//
//    @Before("courseRepositoryFindByIdPC()")
//    public void beforeCourseRepositoryFindById(JoinPoint joinPoint) {
//        //if you use one curly braces in the first string, in the first argument or a parameter of the implemented. Okay.
//        //The second one is going to be replaced by the second parameter after this stream.
//        //Third one is going to be replaced by the third parameter after this string inside the info method. Okay.
//        logger.info("Before -> Method: {}, Arguments: {}, Target: {}"
//                , joinPoint.getSignature(), joinPoint.getArgs(), joinPoint.getTarget());
        //So joinPoint.getSignature() is going to give you that information. You'll be able to see what method you are running.
        //joinPoint.getArgs() for example, it's going to show you what kind of arguments, what arguments are passed into this method.
        // joinPoint.getTarget() this is going to return something different. We are going to see. Okay.


//        @Pointcut("within(com.cydeo.controller..*)")
//    public void anyControllerOperation() {}
//
//    @Pointcut("@within(org.springframework.stereotype.Service)")
//    public void anyServiceOperation() {}
//
//    @Before("anyControllerOperation() || anyServiceOperation()")
//    public void beforeControllerOrServiceAdvice(JoinPoint joinPoint) {
//        logger.info("Before -> Method: {}, Arguments: {}, Target: {}"
//                , joinPoint.getSignature(), joinPoint.getArgs(), joinPoint.getTarget());
//    }

//    @Pointcut("@annotation(org.springframework.web.bind.annotation.DeleteMapping)")
//    public void anyDeleteControllerOperation() {}
//
//    @Before("anyDeleteControllerOperation()")
//    public void beforeDeleteMappingAnnotation(JoinPoint joinPoint) {
//        logger.info("Before -> Method: {}, Arguments: {}, Target: {}"
//                , joinPoint.getSignature(), joinPoint.getArgs(), joinPoint.getTarget());
//    }
//
//    @Pointcut("@annotation(com.cydeo.annotation.LoggingAnnotation)")
//    public void loggingAnnotationPC() {}
//
//    @Before("loggingAnnotationPC()")
//    public void beforeLoggingAnnotation(JoinPoint joinPoint) {
//        logger.info("Before -> Method: {}, Arguments: {}, Target: {}"
//                , joinPoint.getSignature(), joinPoint.getArgs(), joinPoint.getTarget());
//    }
//
//    @Pointcut("@annotation(org.springframework.web.bind.annotation.GetMapping)")
//    public void afterReturningGetMappingAnnotation() {}

//    @AfterReturning(pointcut = "afterReturningGetMappingAnnotation()", returning = "result")
//    public void afterReturningGetMappingOperation(JoinPoint joinPoint, Object result) {
//        logger.info("After Returning -> Method: {}, Result: {}", joinPoint.getSignature(), result.toString());
//    }
//
//    @AfterReturning(pointcut = "afterReturningGetMappingAnnotation()", returning = "results")
//    public void afterReturningGetMappingOperation(JoinPoint joinPoint, List<CourseDTO> results) {
//        logger.info("After Returning -> Method: {}, Result: {}", joinPoint.getSignature(), results.toString());
//    }
//
    // CourseDTO -> Object     --> This is ok
    // List<CourseDTO> -> List<Object>     --> This is not ok
//
//    @AfterThrowing(pointcut = "afterReturningGetMappingAnnotation()", throwing = "exception")
//    public void afterThrowingGetMappingOperation(JoinPoint joinPoint, RuntimeException exception) {
//        logger.error("After Throwing -> Method: {}, Exception: {}"
//                , joinPoint.getSignature().toShortString(), exception.getMessage());
//    }

    @Pointcut("@annotation(com.cydeo.annotation.LoggingAnnotation)")
    public void loggingAnnotationPC() {}

    @Around("loggingAnnotationPC()")
    public Object anyLoggingAnnotationOperation(ProceedingJoinPoint proceedingJoinPoint) {

        logger.info("Before -> Method: {} - Parameter {}"
                , proceedingJoinPoint.getSignature().toShortString(), proceedingJoinPoint.getArgs());

        Object result = null;

        try {
            result = proceedingJoinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

        logger.info("After -> Method: {} - Result: {}"
                , proceedingJoinPoint.getSignature().toShortString(), result.toString());
        return result;

    }
}
