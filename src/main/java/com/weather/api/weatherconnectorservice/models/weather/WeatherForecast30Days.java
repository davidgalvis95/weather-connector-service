package com.weather.api.weatherconnectorservice.models.weather;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Value;

import java.util.List;

@Value
@EqualsAndHashCode(callSuper = true)
@Builder(toBuilder = true)
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class WeatherForecast30Days extends WeatherApiResponse{

    @JsonProperty("cod")
    Integer httpResponseCode;

    CityDescription city;

    @JsonProperty("list")
    List<Weather30ForecastPiece> weather30ForecastList;

    @Builder(toBuilder = true)
    @AllArgsConstructor
    @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
    public record Weather30ForecastPiece(@JsonProperty("dt") Long dateTimestamp,
                                         Double humidity,
                                         Double pressure,
                                         @JsonProperty("temp") TemperatureDetails temperatureDetails,
                                         Double windSpeed) {
    }
}
