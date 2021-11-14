package com.wolfpack.vision.service.impl;

import com.wolfpack.vision.model.*;
import com.wolfpack.vision.model.remote.InrixRouteDetail;
import com.wolfpack.vision.model.remote.InrixRouteOverviewDTO;
import com.wolfpack.vision.persistance.document.Venue;
import com.wolfpack.vision.persistance.document.VisionUser;
import com.wolfpack.vision.rest.InrixRestService;
import com.wolfpack.vision.service.TripPlannerService;
import com.wolfpack.vision.service.UserService;
import com.google.common.collect.Multimaps;
import lombok.extern.log4j.Log4j2;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Log4j2
public class TripPlannerServiceImpl implements TripPlannerService {

    @Autowired private UserService userService;
    @Autowired private InrixRestService inrixRestService;

    @Override
    public InrixRouteOverviewDTO planTrips(String emailId, String lat, String lng, String startDate, String endDate) throws ParseException, IllegalAccessException {
        VisionUser visionUser = userService.findUser(emailId);
        List<InterestDTO> interestDTO = visionUser.getInterest();
        List<String> interests = interestDTO.stream().map(InterestDTO::getName).collect(Collectors.toList());

        List<Venue> venuesCollection = new ArrayList<>();
        for(String section : interests){
            List<Venue> venues = userService.getRecommendations("100000", section, lat, lng, startDate.replaceAll("-",""));
            venuesCollection.addAll(venues);
        }

        FindRouteRequestDTO requestDTO = FindRouteRequestDTO.builder()
                .queryParamDTO(FindRouteQueryParamDTO.builder()
                        .isAmbiguousOrigin(true)
                        .routeOutputFields("B,M,P,S,W")
                        .maxAlternates(2)
                        .format("json")
                        .build())
                .venueList(venuesCollection).build();

        return inrixRestService.getRouteDetails(requestDTO);
    }


}
