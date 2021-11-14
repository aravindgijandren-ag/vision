package com.wolfpack.vision.service.impl;

import com.wolfpack.vision.service.TripPlannerService;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@Log4j2
public class TripPlannerServiceImpl implements TripPlannerService {

    @Override
    public Collection<?> planTrips(long lat, long lng, String startDate, String endDate) {
        //call four square api and get payload
        // make req to ingrix with list[lat, lng]
        return null;
    }
}
