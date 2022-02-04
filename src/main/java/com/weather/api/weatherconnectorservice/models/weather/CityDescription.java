package com.weather.api.weatherconnectorservice.models.weather;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.EqualsAndHashCode;
import lombok.Value;

@Value
@EqualsAndHashCode(callSuper = true)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public record CityDescription(Integer id,
                              String name,
                              @JsonProperty("coord") Coordinates coordinates,
                              String country,
                              Long population,
                              @JsonProperty("timezone") Integer timezoneInSeconds,
                              Long sunrise,
                              Long sunset) {
}
