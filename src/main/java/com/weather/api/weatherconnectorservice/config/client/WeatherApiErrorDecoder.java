package com.weather.api.weatherconnectorservice.config.client;

import com.weather.api.weatherconnectorservice.exception.WeatherApiConnectionError;
import feign.Response;
import feign.codec.ErrorDecoder;

public class WeatherApiErrorDecoder
        implements ErrorDecoder
{
    @Override
    public Exception decode( final String methodKey,
                             final Response response )
    {
        if (response.status() >= 400 && response.status() <= 599) {
            return new WeatherApiConnectionError( "Failed to get info from weather api due to external services failure" );
        }
        return null;
    }
}
