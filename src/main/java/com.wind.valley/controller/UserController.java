package application.controller;

import application.entity.User;
import application.message.ReturnMessage;
import application.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController//相当于下边两个注解
public class UserController {
    @Autowired
    private UserService service;

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
        result.setDada(service.insert(user));
        return result;
    }

    @GetMapping(value = "/wind/test")
    public String query() {
        System.out.println("test");
        return "test";
    }
}