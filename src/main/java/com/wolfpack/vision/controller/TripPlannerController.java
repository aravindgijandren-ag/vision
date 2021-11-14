package com.wolfpack.vision.controller;

import com.wolfpack.vision.service.TripPlannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class TripPlannerController {

    @Autowired private TripPlannerService tripPlannerService;

    @RequestMapping(value = "/" , method = RequestMethod.POST)
    public ResponseEntity<?> planTrips(@RequestParam("latitude") long latitude,
                                       @RequestParam("longitude") long longitude,
                                       @RequestParam("startDate") String startDate,
                                       @RequestParam("endDate") String endDate){

        return ResponseEntity.ok(tripPlannerService.planTrips(latitude, longitude, startDate, endDate));
    }

}
