package com.wind.valley.handler;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class RequestHandler {
    @Pointcut("execution(public * com.wind.valley.controller.UserController.insertUser(..))")
    public void common(){

    }
    @Before("common()")
    public void before(){
        System.out.println("going to insert a user and the request is");
    }
    @After("common()")
    public void after(){
        System.out.println("already to insert a user and the request is");
    }
}
