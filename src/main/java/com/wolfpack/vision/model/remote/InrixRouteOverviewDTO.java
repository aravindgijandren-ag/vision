package com.wolfpack.vision.model.remote;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class InrixRouteOverviewDTO {
    private Integer statusId;
    private String statusText;
    private InrixTripDTO trip;
}
