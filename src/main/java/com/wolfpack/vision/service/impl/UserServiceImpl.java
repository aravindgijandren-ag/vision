package com.wolfpack.vision.service.impl;

import com.wolfpack.vision.persistance.document.VisionUser;
import com.wolfpack.vision.persistance.repository.VisionUserRepo;
import com.wolfpack.vision.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;

@Service
public class UserServiceImpl implements UserService {

    @Autowired private VisionUserRepo visionUserRepo;


    @Override
    public Collection<?> findAll() {
        return visionUserRepo.findAll();
    }

    @Override
    public String getRecommendations(){
        String url = "https://api.foursquare.com/v2/venues/explore?ll=37.34783370332076, -121.93128107414141&section=sights&limit=50&offset=5&client_id=CFK3FJJUDLBXTVVPRKXSCEPEXRTCGQS5E202TH15AXEK12GT&client_secret=YOFZE0CSLM342QXRTWTJFJ32V3WRSAO3434G5BIC4ZDTMUFY&v=20211113";
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(url,String.class);
    }
}
