package com.wolfpack.vision.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class FindRouteQueryParamDTO {
    private Integer maxAlternates;
    private String routeOutputFields;
    private boolean isAmbiguousOrigin;
    private String format;
}
