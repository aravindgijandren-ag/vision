package com.wolfpack.vision.rest;

import org.springframework.stereotype.Service;

@Service
public class RestURL {

    private static final String INGRIX_BASE_URL = "https://api.iq.inrix.com";

    private static final String INGRIX_APP_TOKEN = "/auth/v1/appToken";


    public RestURL(){

    }

    public String getFourSquarePlaceApiEndPoint(){
        return INGRIX_BASE_URL + INGRIX_APP_TOKEN;
    }

}
