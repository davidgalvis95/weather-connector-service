package com.weather.api.weatherconnectorservice.models.weather;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Value;

import java.util.List;

@Value
@EqualsAndHashCode(callSuper = true)
@Builder(toBuilder = true)
@AllArgsConstructor
public class CurrentWeather extends WeatherApiResponse{
    @JsonProperty("coord")
    Coordinates coordinates;

    List<WeatherChild> weather;

    String base;

    @JsonProperty("main")
    WeatherMain weatherMain;

    Integer visibility;

    WeatherWind wind;

    @JsonProperty("dt")
    Long dateTimestamp;

    @JsonProperty("sys")
    SystemLocationDescription systemLocationDescription;

    @JsonProperty("timezone")
    Integer timezoneInSeconds;

    Integer id;

    @JsonProperty("name")
    String cityName;

    @JsonProperty("cod")
    Integer httpResponseCode;
}
