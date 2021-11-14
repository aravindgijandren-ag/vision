package com.wolfpack.vision.service;

import org.json.simple.parser.ParseException;

import java.util.Collection;

public interface TripPlannerService {
    Collection<?> planTrips(String emailId, String lat, String lng, String startDate, String endDate) throws ParseException;
}
