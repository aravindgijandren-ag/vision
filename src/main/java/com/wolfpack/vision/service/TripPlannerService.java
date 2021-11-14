package com.wolfpack.vision.service;

import com.wolfpack.vision.model.remote.InrixRouteOverviewDTO;
import org.json.simple.parser.ParseException;

import java.util.Collection;

public interface TripPlannerService {
    InrixRouteOverviewDTO planTrips(String emailId, String lat, String lng, String startDate, String endDate) throws ParseException, IllegalAccessException;
}
