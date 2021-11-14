package com.wolfpack.vision.service;

import java.util.Collection;

public interface TripPlannerService {
    Collection<?> planTrips(long lat, long lng, String startDate, String endDate);
}
