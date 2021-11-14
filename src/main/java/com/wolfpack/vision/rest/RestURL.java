package com.wolfpack.vision.rest;

import org.springframework.stereotype.Service;

@Service
public class RestURL {

    private static final String INGRIX_BASE_URL = "https://api.iq.inrix.com";

    private static final String INGRIX_APP_TOKEN = "/auth/v1/appToken";

    private static final String FOUR_SQUARE_BASE_URL = "https://api.foursquare.com";

    private static final String FOUR_SQUARE_VENUE_URL = "/v2/venues/explore";


    public RestURL(){

    }

    public String getApplicationTokenApiEndPoint(){
        return INGRIX_BASE_URL + INGRIX_APP_TOKEN;
    }

    public String getFourSquareVenuesApiEndpoint() {
        return FOUR_SQUARE_BASE_URL + FOUR_SQUARE_VENUE_URL;
    }

}
