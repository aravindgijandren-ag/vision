package com.wolfpack.vision.controller;

import com.wolfpack.vision.service.UserService;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

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
    @GetMapping("/getRecommendations")
    public String getreco() throws ParseException {

        JSONParser jsonParser = new JSONParser();
        JSONObject json = (JSONObject) jsonParser.parse(userService.getRecommendations());
        return null;
    }


}
