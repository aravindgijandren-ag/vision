package com.wolfpack.vision.service;

import java.util.Collection;

public interface TripPlannerService {
    Collection<?> planTrips(String lat, String lng, String startDate, String endDate);
}
