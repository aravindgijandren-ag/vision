package com.wolfpack.vision.helper;

import com.wolfpack.vision.model.SignUpDTO;
import com.wolfpack.vision.persistance.document.VisionUser;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class SignUpToVisionUserConv implements Converter<SignUpDTO, VisionUser>{
    @Override
    public VisionUser convert(SignUpDTO input) {
        if(Objects.isNull(input))
            return VisionUser.builder().build();

        return VisionUser.builder()
                .name(input.getName())
                .doB(input.getDob())
                .password(input.getPassword())
                .emailId(input.getEmail())
                .interest(input.getInterest())
                .build();
    }
}
