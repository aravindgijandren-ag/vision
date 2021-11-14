package com.wolfpack.vision.rest;

import org.springframework.http.HttpHeaders;
import org.springframework.util.Base64Utils;

import javax.servlet.http.HttpServletRequest;

public class RestClientHelper {
    private static final String OAUTH_HEADER_AUTH_KEY = "Authorization";
    private static final String HEADER_KEY_BASIC = "Basic ";
    private static final String HEADER_KEY_BEARER = "Bearer ";
    private HttpHeaders httpHeaders;

    public RestClientHelper() {
        this.httpHeaders = new HttpHeaders();
    }

    public RestClientHelper withAccept(String mediaType) {
        httpHeaders.add(HttpHeaders.ACCEPT, mediaType);
        return this;
    }

    public RestClientHelper withContentType(String mediaType) {
        httpHeaders.add(HttpHeaders.CONTENT_TYPE, mediaType);
        return this;
    }

    public RestClientHelper withAuthorization(String token) {
        httpHeaders.add(OAUTH_HEADER_AUTH_KEY, HEADER_KEY_BEARER + token);
        return this;
    }

    public RestClientHelper withAuthorization(HttpServletRequest httpServletRequest) {
        httpHeaders.add(OAUTH_HEADER_AUTH_KEY, httpServletRequest.getHeader(OAUTH_HEADER_AUTH_KEY));
        return this;
    }


    public HttpHeaders build() {
        return this.httpHeaders;
    }


}