package com.wolfpack.vision.service;

import com.wolfpack.vision.model.SignUpDTO;
import com.wolfpack.vision.persistance.document.Venue;
import com.wolfpack.vision.persistance.document.VisionUser;
import org.json.simple.parser.ParseException;

import java.util.List;

public interface UserService {
    List<Venue> getRecommendations(String radius, String section, String latitude, String longitude, String date) throws ParseException;
    VisionUser findAll();
    VisionUser signUp(SignUpDTO signUpDTO);
    VisionUser login(SignUpDTO signUpDTO);
    VisionUser findUser(String emailId);
}
