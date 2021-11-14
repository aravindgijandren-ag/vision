package com.wolfpack.vision.service;

import java.util.Collection;

public interface UserService {
    Collection<?> findAll();
    String getRecommendations();
}
