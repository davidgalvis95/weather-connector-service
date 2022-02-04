package com.weather.api.weatherconnectorservice.models.weather;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.util.List;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public record HistoricalWeatherPiece(@JsonProperty("dt") Long dateTimestamp,
                                     Long sunrise,
                                     Long sunset,
                                     @JsonProperty("temp") Double temperature,
                                     Double feelsLike,
                                     Integer humidity,
                                     Double dewPoint,
                                     Integer clouds,
                                     Integer visibility,
                                     Double windSpeed,
                                     @JsonProperty("wind_deg") Integer windDegreesDirection,
                                     Double windGust,
                                     List<WeatherChild> weather) {
}
