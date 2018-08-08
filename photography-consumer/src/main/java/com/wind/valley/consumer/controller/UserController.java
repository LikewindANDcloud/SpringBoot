package com.wind.valley.consumer.controller;

import com.wind.valley.common.message.ReturnMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import com.wind.valley.common.service.UserService;
import com.wind.valley.common.entity.User;

import javax.validation.Valid;

import static com.alibaba.fastjson.JSON.toJSONString;

@RestController
public class UserController {

    @Autowired
    private UserService service;
    @GetMapping(value = "/insertUser")
    public ReturnMessage<User> insertUser(@Valid User user, BindingResult bindResult) {
        ReturnMessage result = new ReturnMessage();
        if (bindResult.hasErrors()) {
            result.setCode("1");
            result.setMsg(bindResult.getFieldError().getDefaultMessage());
            return result;
        }
        System.out.println("start insert a user");
        result.setCode("0");
        result.setMsg("Success");
        try{
            User u=null;
            u=(User)service.getUser();
            result.setDada(u);
        }catch(Exception e){
            result.setDada("system error");
        }
        return result;
    }
    @GetMapping(value = "/getUser")
    public User getUser(){
        return (User)service.getUser();
    }
}