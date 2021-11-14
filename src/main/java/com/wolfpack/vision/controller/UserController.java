package com.wolfpack.vision.controller;

import com.wolfpack.vision.model.SignUpDTO;
import com.wolfpack.vision.persistance.document.Venue;
import com.wolfpack.vision.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class UserController {

    @Autowired private UserService userService;

    @CrossOrigin(origins = "*")
    @PostMapping("/signup")
    public String signUp(@RequestBody SignUpDTO signUpDTO){
        //System.out.println(userService.findAll());
        userService.signUp(signUpDTO);
        return "hi";
    }
    @GetMapping("/getRecommendations")
    public List<Venue> getreco(@RequestParam(name = "radius") String radius,
                               @RequestParam(name = "section") String section,
                               @RequestParam(name = "latitude") String latitude,
                               @RequestParam(name = "longitude") String longitude,
                               @RequestParam(name = "date") String date) throws ParseException {

        return userService.getRecommendations(radius, section, latitude, longitude, date);
    }



}
