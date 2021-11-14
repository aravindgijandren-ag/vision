package com.wolfpack.vision.rest;

import com.wolfpack.vision.model.InrixAuthDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

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
        log.info("hello");
    }

    public void getRouteDetails(){
        //InrixRouteOverviewDTO
    }

}
