package com.wind.valley.controller;

import com.wind.valley.entity.User;
import com.wind.valley.message.ReturnMessage;
import com.wind.valley.redis.RedisClient;
import com.wind.valley.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import static com.alibaba.fastjson.JSON.toJSONString;

@RestController//相当于下边两个注解
public class UserController {
    @Autowired
    private UserService service;
    @Autowired
    private RedisClient redisClient;
    @PostMapping(value = "/wind/hello")
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
            u=service.insert(user);
            result.setDada(u);
            redisClient.set(user.getName(),toJSONString(user));
        }catch(Exception e){
            result.setDada("system error");
        }

        return result;
    }
}