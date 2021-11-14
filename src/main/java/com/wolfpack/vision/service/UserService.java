package com.wolfpack.vision.service;

import com.wolfpack.vision.persistance.document.VisionUser;

import java.util.Collection;

public interface UserService {
    String getRecommendations(String radius, String section, String latitude, String longitude, String date);
    VisionUser findAll();
}
