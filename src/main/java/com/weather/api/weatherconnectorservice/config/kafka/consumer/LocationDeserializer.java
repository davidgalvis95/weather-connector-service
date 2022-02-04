package com.weather.api.weatherconnectorservice.config.kafka.consumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.weather.api.weatherconnectorservice.models.Location;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.common.serialization.Deserializer;

import java.nio.charset.StandardCharsets;
import java.util.Map;

@Slf4j
public class LocationDeserializer implements Deserializer<Location>{

        private final ObjectMapper objectMapper = new ObjectMapper();

        @Override
        public void configure(Map<String, ?> configs, boolean isKey) {
            Deserializer.super.configure(configs, isKey);
        }

        @Override
        public Location deserialize(String topic, byte[] data) {
            try {
                return objectMapper.readValue(new String(data, StandardCharsets.UTF_8), Location.class);
            } catch (JsonProcessingException e) {
                log.error("Unable to deserialize message {}", data, e);
                return null;
            }
        }

        @Override
        public void close() {
            Deserializer.super.close();
        }

}
