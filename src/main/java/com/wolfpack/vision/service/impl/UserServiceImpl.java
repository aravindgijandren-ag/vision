package com.wolfpack.vision.service.impl;

import com.wolfpack.vision.persistance.document.VisionUser;
import com.wolfpack.vision.persistance.repository.VisionUserRepo;
import com.wolfpack.vision.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class UserServiceImpl implements UserService {

    @Autowired private VisionUserRepo visionUserRepo;

    @Override
    public Collection<?> findAll() {
        return visionUserRepo.findAll();
    }
}
