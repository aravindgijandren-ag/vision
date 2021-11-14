package com.wolfpack.vision.service.impl;

import com.wolfpack.vision.model.FindRouteQueryParamDTO;
import com.wolfpack.vision.model.FindRouteRequestDTO;
import com.wolfpack.vision.model.InterestDTO;
import com.wolfpack.vision.model.remote.InrixRouteOverviewDTO;
import com.wolfpack.vision.persistance.document.Venue;
import com.wolfpack.vision.persistance.document.VisionUser;
import com.wolfpack.vision.rest.InrixRestService;
import com.wolfpack.vision.service.TripPlannerService;
import com.wolfpack.vision.service.UserService;
import lombok.extern.log4j.Log4j2;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

@Service
@Log4j2
public class TripPlannerServiceImpl implements TripPlannerService {

    @Autowired private UserService userService;
    @Autowired private InrixRestService inrixRestService;

    @Override
    public InrixRouteOverviewDTO planTrips(String emailId, String lat, String lng, String startDate, String endDate) throws ParseException, IllegalAccessException {
        VisionUser visionUser = userService.findUser(emailId);
        List<InterestDTO> interestDTO = visionUser.getInterest();


        PriorityQueue<Venue> minHeap = new PriorityQueue<>(10,(a, b) -> Integer.compare(a.getScore(),b.getScore()));

        List<Venue> venuesCollection = new ArrayList<>();
        for(InterestDTO dto : interestDTO){
            int rating = dto.getRatings();
            List<Venue> venues = userService.getRecommendations("100000", dto.getName(), lat, lng, startDate.replaceAll("-",""));
            for(Venue v : venues){
                int score = (int) ((0.6*rating) + (0.4*v.getLocation().getDistance()));
                v.setScore(score);
                minHeap.add(v);
            }
            venuesCollection.addAll(venues);
        }

        FindRouteRequestDTO requestDTO = FindRouteRequestDTO.builder()
                .queryParamDTO(FindRouteQueryParamDTO.builder()
                        .isAmbiguousOrigin(true)
                        .routeOutputFields("B,M,P,S,W")
                        .maxAlternates(2)
                        .format("json")
                        .build())
                .venues(minHeap).build();

        return inrixRestService.getRouteDetails(requestDTO);
    }


}
