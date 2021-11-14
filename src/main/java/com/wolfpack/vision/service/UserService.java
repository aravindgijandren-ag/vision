package com.wolfpack.vision.service;

import com.wolfpack.vision.persistance.document.VisionUser;

public interface UserService {
    String getRecommendations();
    VisionUser findAll();
}
