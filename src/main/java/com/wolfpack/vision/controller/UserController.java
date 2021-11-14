package com.wolfpack.vision.controller;

import com.wolfpack.vision.model.SignUpDTO;
import com.wolfpack.vision.persistance.document.Venue;
import com.wolfpack.vision.persistance.document.VisionUser;
import com.wolfpack.vision.service.UserService;

import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@Slf4j
public class UserController {

    @Autowired private UserService userService;

    @PostMapping("/signup")
    public String signUp(@RequestBody SignUpDTO signUpDTO){
        //System.out.println(userService.findAll());
        userService.signUp(signUpDTO);
        return "hi";
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody SignUpDTO signUpDTO){
        VisionUser visionUser = userService.login(signUpDTO);
        if(Objects.nonNull(visionUser))
            return ResponseEntity.ok(visionUser);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Check credentials");
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
