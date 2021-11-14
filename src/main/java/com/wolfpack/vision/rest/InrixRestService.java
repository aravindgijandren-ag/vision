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

        List<Venue> venueList = findRouteRequestDTO.getVenueList();

        List<String> geo_codings = venueList.stream()
                .map(v -> v.getLocation().getLatitude() + ", "+v.getLocation().getLongitude())
                .collect(Collectors.toList());

        int counter = 1;
        for(String location_identifier : geo_codings){
            if(counter > 9)
                break;
            String wayPoint = "wp_" + counter;
            queryParams.add(wayPoint, location_identifier);
            counter++;
        }

        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder
                .fromUriString(restUrl.getFindRouteEndpoint()).queryParams(queryParams);
        uriComponentsBuilder.encode(StandardCharsets.UTF_8);

        return restTemplateService.makeHttpRequest(null, headers, uriComponentsBuilder, HttpMethod.GET,
                new ParameterizedTypeReference<InrixRouteOverviewDTO>() {
                });

    }

}
