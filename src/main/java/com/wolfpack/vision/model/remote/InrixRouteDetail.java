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
public class InrixRouteDetail {
    private Integer id;
    private Integer travelTimeMinutes;
    private Double averageSpeed;
    private String totalDistance;
    private InrixPointDTO points;

}
