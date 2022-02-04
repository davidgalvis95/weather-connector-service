package com.weather.api.weatherconnectorservice.kafka.consumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.weather.api.weatherconnectorservice.models.Location;
import com.weather.api.weatherconnectorservice.service.LocationProcessorService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@Slf4j
@AllArgsConstructor
public class LocationConnectorConsumer {

    private LocationProcessorService locationProcessorService;

    @KafkaListener(
            topics = {"location-connector-events"}
    )
    public void onMessage(ConsumerRecord<UUID, Location> record) throws JsonProcessingException {
        log.info("ConsumerRecord : {} ", record);
        this.locationProcessorService.processLocationAndGetWeather(record);
    }
}
