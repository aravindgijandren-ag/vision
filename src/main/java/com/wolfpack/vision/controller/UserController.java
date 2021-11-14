package com.wolfpack.vision.controller;

import com.wolfpack.vision.persistance.document.Venue;
import com.wolfpack.vision.service.UserService;

import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
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
        String venues = userService.getRecommendations();
        JSONObject jsonObject = (JSONObject) jsonParser.parse(venues);
        Venue venue = new Venue();
        JSONObject response = (JSONObject) jsonObject.get("response");
        return null;
    }


}
