package com.wolfpack.vision.service.impl;

import com.wolfpack.vision.persistance.document.VisionUser;
import com.wolfpack.vision.persistance.repository.VisionUserRepo;
import com.wolfpack.vision.rest.InrixRestService;
import com.wolfpack.vision.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

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

    @Override
    public String getRecommendations(){
        String url = "https://api.foursquare.com/v2/venues/explore?ll=37.34783370332076, -121.93128107414141&section=sights&limit=50&offset=5&client_id=CFK3FJJUDLBXTVVPRKXSCEPEXRTCGQS5E202TH15AXEK12GT&client_secret=YOFZE0CSLM342QXRTWTJFJ32V3WRSAO3434G5BIC4ZDTMUFY&v=20211113";
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(url,String.class);
    }
}
