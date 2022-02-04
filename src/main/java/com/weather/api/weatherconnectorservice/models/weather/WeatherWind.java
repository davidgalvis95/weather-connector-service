package com.weather.api.weatherconnectorservice.models.weather;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

@Builder(toBuilder = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public record WeatherWind(Double speed,
                          @JsonProperty("deg")
                          Integer degreesDirection,
                          Double gust) {
}
