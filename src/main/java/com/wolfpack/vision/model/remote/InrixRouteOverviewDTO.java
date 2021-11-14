package com.wolfpack.vision.model.remote;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class InrixRouteOverviewDTO {
    private Integer statusId;
    private String statusText;
    private FindRouteRes result;
}
