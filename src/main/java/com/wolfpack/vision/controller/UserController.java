package com.wolfpack.vision.controller;

import com.wolfpack.vision.model.SignUpDTO;
import com.wolfpack.vision.persistance.document.Venue;
import com.wolfpack.vision.persistance.document.VisionUser;
import com.wolfpack.vision.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@Slf4j
public class UserController {

    @Autowired private UserService userService;

    @CrossOrigin(origins = "*")
    @PostMapping("/signup")
    public ResponseEntity<?> signUp(@RequestBody SignUpDTO signUpDTO){
        return ResponseEntity.ok(userService.signUp(signUpDTO));
    }

    @PostMapping("/login")
    @CrossOrigin(origins = "*")
    public ResponseEntity<?> login(@RequestBody SignUpDTO signUpDTO){
        VisionUser visionUser = userService.login(signUpDTO);
        if(Objects.nonNull(visionUser))
            return ResponseEntity.ok(visionUser);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Check credentials");
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
