package com.weather.api.weatherconnectorservice.models;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.LinkedList;

@Builder(toBuilder = true)
@Data
public class LocationProcessorExtracted {

    private LocationTreeType type;

    private String locationName;

    private Double latitude;

    private Double distance;

    private Double longitude;
}
