package com.weather.api.weatherconnectorservice.models.weather;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Builder;

@Builder(toBuilder = true)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public record TemperatureDetails2(@JsonProperty("day") Double duringDay,
                                  Double max,
                                  Double min,
                                  @JsonProperty("night") Double duringNight,
                                  @JsonProperty("eve") Double duringEve,
                                  @JsonProperty("morn") Double duringMorning) {
}
