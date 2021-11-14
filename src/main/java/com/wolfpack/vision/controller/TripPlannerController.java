package com.wolfpack.vision.controller;

import com.wolfpack.vision.service.TripPlannerService;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
public class TripPlannerController {

    @Autowired private TripPlannerService tripPlannerService;


    @RequestMapping(value = "/trip/plan" , method = RequestMethod.GET)
    public ResponseEntity<?> planTrips(@RequestParam("latitude") String latitude,
                                       @RequestParam("longitude") String longitude,
                                       @RequestParam("startDate") String startDate,
                                       @RequestParam("endDate") String endDate,
                                       @RequestParam("emailId") String emailId) throws ParseException {
        return ResponseEntity.ok(tripPlannerService.planTrips(emailId, latitude, longitude, startDate, endDate));
    }

}
