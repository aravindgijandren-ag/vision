package com.wolfpack.vision.rest;

import com.wolfpack.vision.model.FindRouteQueryParamDTO;
import com.wolfpack.vision.model.FindRouteRequestDTO;
import com.wolfpack.vision.model.InrixAuthDTO;
import com.wolfpack.vision.model.remote.InrixRouteOverviewDTO;
import com.wolfpack.vision.persistance.document.Venue;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.util.UriComponentsBuilder;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

@Service
@Slf4j
public class InrixRestService {
    @Autowired
    private RestTemplateService restTemplateService;
    @Autowired
    private RestURL restUrl;


    public void getApplicationToken(){
        HttpHeaders headers = new RestClientHelper().build();
        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromUriString(restUrl.getApplicationTokenApiEndPoint());
        uriComponentsBuilder.queryParam("appId", "hrfi4fcnp1");
        uriComponentsBuilder.queryParam("hashToken", "aHJmaTRmY25wMXxIYkhXTUNhY3lMOXVhRkMwdldIRzl5bWs3cW9qY3M2Mmptd3YyVXNm");

        InrixAuthDTO response = restTemplateService.makeHttpRequest(null, headers, uriComponentsBuilder, HttpMethod.GET,
                new ParameterizedTypeReference<InrixAuthDTO>() {
                });
    }

    public InrixRouteOverviewDTO getRouteDetails(FindRouteRequestDTO findRouteRequestDTO) throws IllegalAccessException {
        HttpHeaders headers = new RestClientHelper().withAuthorization(restUrl.getInrixApiKey()).build();

        final MultiValueMap<String, String> queryParams = QueryParamUtil
                .buildQueryParams(findRouteRequestDTO.getQueryParamDTO());

        PriorityQueue<Venue> venues = findRouteRequestDTO.getVenues();

        int counter=1;
        while(!venues.isEmpty() && counter < 4){
            Venue venue = venues.poll();
            String location_identifier =venue.getLocation().getLatitude() + ", "+ venue.getLocation().getLongitude();
            String wayPoint = "wp_" + counter;
            queryParams.add(wayPoint, location_identifier);
            counter++;
        }

        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder
                .fromUriString(restUrl.getFindRouteEndpoint()).queryParams(queryParams);
        uriComponentsBuilder.encode(StandardCharsets.UTF_8);

        log.info("Contacting inrix api");

        return restTemplateService.makeHttpRequest(null, headers, uriComponentsBuilder, HttpMethod.GET,
                new ParameterizedTypeReference<InrixRouteOverviewDTO>() {
                });

    }

}
