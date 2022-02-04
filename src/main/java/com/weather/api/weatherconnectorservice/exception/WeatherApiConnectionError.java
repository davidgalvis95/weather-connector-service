package com.weather.api.weatherconnectorservice.exception;

import java.net.ConnectException;

public class WeatherApiConnectionError extends ConnectException {

    public WeatherApiConnectionError(String msg) {
        super(msg);
    }

    public WeatherApiConnectionError() {}
}
