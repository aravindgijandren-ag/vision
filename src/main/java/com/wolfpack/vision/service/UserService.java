package com.wolfpack.vision.service;

import com.wolfpack.vision.model.SignUpDTO;
import com.wolfpack.vision.persistance.document.VisionUser;

public interface UserService {
    String getRecommendations();
    VisionUser findAll();
    VisionUser signUp(SignUpDTO signUpDTO);
}
