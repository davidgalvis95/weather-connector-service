package com.weather.api.weatherconnectorservice.service;

import com.weather.api.weatherconnectorservice.models.Location;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public interface LocationProcessorService {
    void processLocationAndGetWeather(ConsumerRecord<UUID, Location> consumerRecord);
}
