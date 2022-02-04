package com.weather.api.weatherconnectorservice.models.weather;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Builder;

@Builder(toBuilder = true)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public record WeatherMain(Double temperature,
                          Double tempFeelsLike,
                          Double tempMin,
                          Double tempMax,
                          Double pressure,
                          Double seaLevel,
                          Double groundLevel,
                          Integer humidity,
                          Double tempKf) {
}
