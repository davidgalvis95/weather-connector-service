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
public class Historic5DaysWeather extends WeatherApiResponse {

    @JsonProperty("lat")
    Double latitude;

    @JsonProperty("lon")
    Double longitude;

    String timezone;

    Integer timezoneOffsetInSeconds;

    HistoricalWeatherPiece current;

    @JsonProperty("hourly")
    List<HistoricalWeatherPiece> hourlyHistory;
}
