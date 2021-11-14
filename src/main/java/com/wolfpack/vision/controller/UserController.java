package com.wolfpack.vision.controller;

import com.wolfpack.vision.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired private UserService userService;

    @RequestMapping("hello")
    public String find(){
        System.out.println(userService.findAll());
        return "hi";
    }
}
