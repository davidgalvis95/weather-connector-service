package com.weather.api.weatherconnectorservice.models.weather;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Value;

import java.util.List;

@Builder(toBuilder = true)
@AllArgsConstructor
public class WeatherForecast16Days extends WeatherApiResponse {
    CityDescription city;

    @JsonProperty("cod")
    Integer httpResponseCode;

    @JsonProperty("cnt")
    Integer count;

    List<Weather16ForecastPiece> weather16ForecastList;


    @Builder(toBuilder = true)
    @AllArgsConstructor
    @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
    public record Weather16ForecastPiece(@JsonProperty("dt") Long dateTimestamp,
                                         @JsonProperty("main") WeatherMain weatherMain,
                                         @JsonProperty("temp") TemperatureDetails2 temperatureDetails,
                                         TemperatureDetails2 feelsLike,
                                         Integer pressure,
                                         Integer humidity,
                                         List<WeatherChild> weather,
                                         Double speed,
                                         @JsonProperty("deg") Integer degreesDirection,
                                         Double gust,
                                         Integer visibility) {

    }
}
