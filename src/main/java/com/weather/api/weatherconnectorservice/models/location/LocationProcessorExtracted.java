package com.weather.api.weatherconnectorservice.models.location;

import lombok.Builder;
import lombok.Data;

@Builder(toBuilder = true)
@Data
public class LocationProcessorExtracted {

    private LocationTreeType type;

    private String locationName;

    private Double latitude;

    private Double distance;

    private Double longitude;
}
