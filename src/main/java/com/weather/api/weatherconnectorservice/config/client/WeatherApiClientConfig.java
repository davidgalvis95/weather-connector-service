package com.weather.api.weatherconnectorservice.config.client;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.weather.api.weatherconnectorservice.client.WeatherApiClient;
import feign.Feign;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class WeatherApiClientConfig {

    private final String weatherApiUrl;

    private final ObjectMapper objectMapper;

    @Autowired
    public WeatherApiClientConfig(final ObjectMapper objectMapper, @Value("${weather.api.url}") final String weatherApiUrl){
        this.weatherApiUrl = weatherApiUrl;
        this.objectMapper = objectMapper;
    }

    @Bean
    public WeatherApiClient weatherApiClient(){
        return Feign.builder()
                .encoder( new GsonEncoder() )
                .decoder( new GsonDecoder())
                .errorDecoder( new WeatherApiErrorDecoder() )
                .target( WeatherApiClient.class, weatherApiUrl );
    }

}
