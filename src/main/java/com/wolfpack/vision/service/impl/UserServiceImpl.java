package com.wolfpack.vision.service.impl;

import com.wolfpack.vision.helper.SignUpToVisionUserConv;
import com.wolfpack.vision.model.InterestDTO;
import com.wolfpack.vision.model.SignUpDTO;
import com.wolfpack.vision.persistance.document.Location;
import com.wolfpack.vision.persistance.document.Venue;
import com.wolfpack.vision.persistance.document.VisionUser;
import com.wolfpack.vision.persistance.repository.VisionUserRepo;
import com.wolfpack.vision.rest.FourSquareRestService;
import com.wolfpack.vision.rest.InrixRestService;
import com.wolfpack.vision.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.PriorityQueue;

@Service
@Slf4j
public class UserServiceImpl implements UserService {
    Location location1 = new Location();

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
    public List<Venue> getRecommendations(String radius, String section, String latitude, String longitude, String date) throws ParseException {

        String venues = fourSquareRestService.getVenueRecommendations(radius, section, latitude, longitude, date);
        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject = (JSONObject) jsonParser.parse(venues);
        List<Venue> venueList = new ArrayList<>();
        JSONObject response = (JSONObject) jsonObject.get("response");
        JSONArray groups = (JSONArray) response.get("groups");
        groups.stream().forEach(group -> {
            JSONObject groupJson = (JSONObject) group;
            JSONArray items = (JSONArray) groupJson.get("items");
            items.stream().forEach(item -> {
                JSONObject itemJson = (JSONObject) item;
                JSONObject venueJson = (JSONObject) itemJson.get("venue");
                Venue venue = new Venue();
                venue.setName((String) venueJson.get("name"));
                JSONObject locationJson = (JSONObject) venueJson.get("location");
                Location location = new Location();
                location.setLongitude(String.valueOf(locationJson.get("lng")));
                location.setLatitude(String.valueOf(locationJson.get("lat")));
                location.setDistance(Double.parseDouble(String.valueOf(locationJson.get("distance"))));
                //location1.setDistance(Double.parseDouble(String.valueOf(locationJson.get("distance"))));
                venue.setLocation(location);
                venueList.add(venue);
            });
        });
        log.info("VENUE LIST: {}", venueList.size());
        return venueList;
    }
    public VisionUser signUp(SignUpDTO signUpDTO) {
        return visionUserRepo.save(signUpToVisionUserConv.convert(signUpDTO));
    }

    @Override
    public VisionUser login(SignUpDTO signUpDTO){
        String email = signUpDTO.getEmail();
        String password = signUpDTO.getPassword();
        VisionUser visionUser = findUser(email);
        if(Objects.nonNull(visionUser) && visionUser.getPassword().equals(password)){
            return visionUser;
        }
        return null;
    }

    @Override
    public VisionUser findUser(String emailId) {
        return visionUserRepo.findOneByEmailId(emailId);
    }

}
