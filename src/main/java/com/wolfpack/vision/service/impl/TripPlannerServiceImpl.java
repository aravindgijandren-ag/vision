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
        List<String> interests = interestDTO.stream().map(InterestDTO::getName).collect(Collectors.toList());

        List<Venue> venuesCollection = new ArrayList<>();
        for(String section : interests){
            List<Venue> venues = userService.getRecommendations("100000", section, lat, lng, startDate.replaceAll("-",""));
            venuesCollection.addAll(venues);
        }

        return null;
    }


}
