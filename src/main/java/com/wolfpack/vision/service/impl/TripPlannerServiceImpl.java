package com.wolfpack.vision.service.impl;

import com.wolfpack.vision.model.InterestDTO;
import com.wolfpack.vision.persistance.document.Venue;
import com.wolfpack.vision.persistance.document.VisionUser;
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
import java.util.PriorityQueue;
import java.util.stream.Collectors;

@Service
@Log4j2
public class TripPlannerServiceImpl implements TripPlannerService {

    @Autowired private UserService userService;

    @Override
    public Collection<?> planTrips(String emailId, String lat, String lng, String startDate, String endDate) throws ParseException {
        //call four square api and get payload
        // make req to ingrix with list[lat, lng]
        /*Multimap<Integer, VendorSkuSetMapModel> allVendorSkuSetMapMultipMap = Multimaps.index(vendorSkuSetMapModels,
                item -> item.getSkuSetConfiguration().getSku().getId());*/

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
            //venuesCollection.addAll(venues);
        }

        return null;
    }


}
