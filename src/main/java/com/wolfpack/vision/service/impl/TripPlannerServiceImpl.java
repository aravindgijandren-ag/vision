package com.wolfpack.vision.service.impl;

import com.wolfpack.vision.service.TripPlannerService;
import com.wolfpack.vision.service.UserService;
import lombok.extern.log4j.Log4j2;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@Log4j2
public class TripPlannerServiceImpl implements TripPlannerService {

    @Autowired private UserService userService;

    @Override
    public Collection<?> planTrips(String emailId, String lat, String lng, String startDate, String endDate) throws ParseException {
        //call four square api and get payload
        // make req to ingrix with list[lat, lng]
        userService.getRecommendations("50","", lat, lng, startDate);
        return null;
    }
}
