package com.wolfpack.vision.rest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.nio.charset.StandardCharsets;

@Service
@Slf4j
public class FourSquareRestService {

    private static final String QUERY_PARAM_RADIUS = "radius";
    private static final String QUERY_PARAM_SECTION = "section";
    private static final String QUERY_PARAM_CLIENT_ID = "client_id";
    private static final String QUERY_PARAM_CLIENT_SECRET = "client_secret";
    private static final String QUERY_PARAM_V = "v";
    private static final String QUERY_PARAM_LL = "ll";
    private static final String CLIENT_ID = "CFK3FJJUDLBXTVVPRKXSCEPEXRTCGQS5E202TH15AXEK12GT";
    private static final String CLIENT_SECRET = "YOFZE0CSLM342QXRTWTJFJ32V3WRSAO3434G5BIC4ZDTMUFY";


    @Autowired
    private RestTemplateService restTemplateService;

    @Autowired
    private RestURL restUrl;

    public String getVenueRecommendations(String radius, String section, String latitude, String longitude, String date){
        HttpHeaders headers = new RestClientHelper().build();
        String location = latitude + ", " + longitude;
        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromUriString(restUrl.getFourSquareVenuesApiEndpoint());
        uriComponentsBuilder
                .queryParam(QUERY_PARAM_CLIENT_ID, CLIENT_ID)
                .queryParam(QUERY_PARAM_CLIENT_SECRET, CLIENT_SECRET)
                .queryParam(QUERY_PARAM_RADIUS, radius)
                .queryParam(QUERY_PARAM_SECTION, section)
                .queryParam(QUERY_PARAM_V, date)
                .queryParam(QUERY_PARAM_LL, location);
        uriComponentsBuilder.encode(StandardCharsets.UTF_8);
        String response = restTemplateService.makeHttpRequest(null, headers, uriComponentsBuilder, HttpMethod.GET,
                String.class);
        return response;
    }
}
