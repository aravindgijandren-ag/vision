package com.wolfpack.vision.service.impl;

import com.wolfpack.vision.persistance.document.VisionUser;
import com.wolfpack.vision.persistance.repository.VisionUserRepo;
import com.wolfpack.vision.rest.InrixRestService;
import com.wolfpack.vision.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired private VisionUserRepo visionUserRepo;

    @Autowired private InrixRestService inrixRestService;

    @Override
    public VisionUser findAll() {
        System.out.println("HI");

        inrixRestService.getApplicationToken();

        return visionUserRepo.findById("6190586de05cb28b5c8addf5").get();
    }
}
