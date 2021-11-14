package com.wolfpack.vision.controller;

import com.wolfpack.vision.persistance.document.Location;
import com.wolfpack.vision.persistance.document.Venue;
import com.wolfpack.vision.service.UserService;

import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@Slf4j
public class UserController {

    @Autowired private UserService userService;

    @RequestMapping("hello")
    public String find(){
        System.out.println(userService.findAll());
        return "hi";
    }
    @GetMapping("/getRecommendations")
    public List<Venue> getreco(@RequestParam(name = "radius") String radius,
                               @RequestParam(name = "section") String section,
                               @RequestParam(name = "latitude") String latitude,
                               @RequestParam(name = "longitude") String longitude,
                               @RequestParam(name = "date") String date) throws ParseException {
        JSONParser jsonParser = new JSONParser();
        String venues = userService.getRecommendations(radius, section, latitude, longitude, date);
        JSONObject jsonObject = (JSONObject) jsonParser.parse(venues);
        List<Venue> venueList = new ArrayList<>();
        JSONObject response = (JSONObject) jsonObject.get("response");
        JSONArray groups = (JSONArray) response.get("groups");
        log.info("Group LIST: {}", groups);
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
                venue.setLocation(location);
                venueList.add(venue);
            });
        });
        log.info("VENUE LIST: {}", venueList);
        return venueList;
    }


}
