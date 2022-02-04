package com.weather.api.weatherconnectorservice.models.weather;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;

import java.util.List;

@Builder(toBuilder = true)
@AllArgsConstructor
public class WeatherForecastEach3HoursDuring5Days extends WeatherApiResponse{

    @JsonProperty("cod")
    Integer httpResponseCode;

    @JsonProperty("cnt")
    Integer count;

    @JsonProperty("list")
    List<WeatherForecast> weatherForecastList;

    CityDescription city;

    @Builder(toBuilder = true)
    @AllArgsConstructor
    public record WeatherForecast(@JsonProperty("dt") Long dateTimestamp,
                                  @JsonProperty("main") WeatherMain weatherMain,
                                  List<WeatherChild> weather,
                                  WeatherWind wind,
                                  Integer visibility) {

    }
}
