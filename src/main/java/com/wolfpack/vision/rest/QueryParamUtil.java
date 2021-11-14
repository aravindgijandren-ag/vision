package com.wolfpack.vision.rest;

import org.apache.tomcat.util.buf.StringUtils;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.lang.reflect.Field;
import java.util.List;

public final class QueryParamUtil {

    public static MultiValueMap<String, String> buildQueryParams(Object param) throws IllegalAccessException {
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        if (param == null) {
            return params;
        }
        for (Field field : param.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            Object value = field.get(param);
            if(value != null){
                if(value instanceof List<?>){
                    params.add(field.getName(), StringUtils.join((List<String>)value,','));
                }else{
                    params.add(field.getName(), String.valueOf(value));
                }
            }
        }
        return params;
    }

    private QueryParamUtil() {
        throw new AssertionError();
    }
}