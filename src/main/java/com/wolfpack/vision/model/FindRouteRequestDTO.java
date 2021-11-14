package com.wolfpack.vision.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.wolfpack.vision.persistance.document.Venue;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.PriorityQueue;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class FindRouteRequestDTO {
    private FindRouteQueryParamDTO queryParamDTO;
    private PriorityQueue<Venue> venues;
}
