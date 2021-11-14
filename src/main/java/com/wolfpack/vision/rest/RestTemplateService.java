package com.wolfpack.vision.rest;

import com.wolfpack.vision.excpetion.ErrorCode;
import com.wolfpack.vision.helper.ApplicationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.ConnectException;
import java.net.SocketTimeoutException;

@Service
@Slf4j
public class RestTemplateService {
    @Autowired
    private RestTemplate restTemplate;

    public <T> T makeHttpRequest(Object input, HttpHeaders httpHeaders, UriComponentsBuilder builder, HttpMethod verb, Class<T> clazz) {
        HttpEntity<?> response = null;
        try {
            HttpEntity<?> entity = new HttpEntity<>(input, httpHeaders);
            response = restTemplate.exchange(builder.build().encode().toUri(), verb, entity, clazz);
        } catch (HttpClientErrorException exc) {
            log.error("Excpetion during url:{}", builder.toUriString(), exc);
            handleError(exc);
        } catch (RestClientException exc) {
            log.error("Excpetion during url:{}", builder.toUriString(), exc);
            throw new ApplicationException(ErrorCode.CLIENT_ERROR);
        }
        return handleSuccess(response);
    }

    public <T> T makeHttpRequest(Object input, HttpHeaders httpHeaders, UriComponentsBuilder builder, HttpMethod verb, ParameterizedTypeReference<T> type) {
        HttpEntity<?> response = null;
        try {
            HttpEntity<?> entity = new HttpEntity<>(input, httpHeaders);
            response = restTemplate.exchange(builder.build().encode().toUri(), verb, entity, type);
        } catch (HttpClientErrorException exc) {
            log.error("Excpetion during url:{}", builder.toUriString(), exc);
            return handleError(exc);
        }
        return handleSuccess(response);
    }

    public <T> T makeHttpRequestV2(Object input, HttpHeaders httpHeaders, UriComponentsBuilder builder, HttpMethod verb, ParameterizedTypeReference<T> type) {
        HttpEntity<?> response = null;
        try {
            HttpEntity<?> entity = new HttpEntity<>(input, httpHeaders);
            response = restTemplate.exchange(builder.build().encode().toUri(), verb, entity, type);
        } catch (HttpClientErrorException| HttpServerErrorException exc ) {
            log.error("Excpetion during url:{}", builder.toUriString(), exc);
            return handleError(exc);
        }
        return handleSuccess(response);
    }

    private <T> T handleError(HttpStatusCodeException exc) {
        if (exc.getRootCause() instanceof ConnectException)
            throw new ApplicationException(ErrorCode.SERVER_UNREACHABLE);
        if (exc.getRootCause() instanceof SocketTimeoutException)
            throw new ApplicationException(ErrorCode.TIME_OUT);
        throw new ApplicationException(exc.getStatusText(),exc.getMessage());
    }

    private <T> T handleSuccess(HttpEntity<?> response) throws ApplicationException {
        if (response == null) throw new ApplicationException(ErrorCode.EMPTY_RESPONSE);
        return (T) response.getBody();
    }

}