package com.weather.api.weatherconnectorservice.models.weather;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.EqualsAndHashCode;
import lombok.Value;

@Value
@EqualsAndHashCode(callSuper = true)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public record SystemLocationDescription(Integer type,
                                        Integer id,
                                        String country,
                                        Long sunrise,
                                        Long sunset) {

}
