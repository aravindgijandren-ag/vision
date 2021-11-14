package com.wolfpack.vision.service.impl;

import com.wolfpack.vision.excpetion.ErrorCode;
import com.wolfpack.vision.helper.ApplicationException;
import com.wolfpack.vision.helper.SignUpToVisionUserConv;
import com.wolfpack.vision.model.SignUpDTO;
import com.wolfpack.vision.persistance.document.VisionUser;
import com.wolfpack.vision.persistance.repository.VisionUserRepo;
import com.wolfpack.vision.rest.FourSquareRestService;
import com.wolfpack.vision.rest.InrixRestService;
import com.wolfpack.vision.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {

    @Autowired private VisionUserRepo visionUserRepo;

    @Autowired private InrixRestService inrixRestService;

    @Autowired
    private FourSquareRestService fourSquareRestService;

    @Autowired private SignUpToVisionUserConv signUpToVisionUserConv;


    @Override
    public VisionUser findAll() {
        System.out.println("HI");

        inrixRestService.getApplicationToken();

        return visionUserRepo.findById("6190586de05cb28b5c8addf5").get();
    }

    @Override
    public VisionUser signUp(SignUpDTO signUpDTO) {
        return visionUserRepo.save(signUpToVisionUserConv.convert(signUpDTO));
    }

    @Override
    public VisionUser login(SignUpDTO signUpDTO){
        String email = signUpDTO.getEmail();
        String password = signUpDTO.getPassword();
        VisionUser visionUser = visionUserRepo.findOneByEmailId(email);
        if(Objects.nonNull(visionUser) && visionUser.getPassword().equals(password)){
            return visionUser;
        }
        return null;
    }

    @Override
    public String getRecommendations(){
         return fourSquareRestService.getVenueRecommendations("250", "sights", "37.34783370332076", "-121.93128107414141", "20211113");
    }
}
