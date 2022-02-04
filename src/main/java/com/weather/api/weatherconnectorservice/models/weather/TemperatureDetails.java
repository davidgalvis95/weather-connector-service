package com.weather.api.weatherconnectorservice.models.weather;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Builder;

@Builder(toBuilder = true)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public record TemperatureDetails(Double average,
                                 Double averageMax,
                                 Double averageMin,
                                 Double recordMax,
                                 Double recordMin) {
}
