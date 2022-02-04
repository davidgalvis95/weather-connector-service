package com.weather.api.weatherconnectorservice.service;

import com.weather.api.weatherconnectorservice.models.Location;
import com.weather.api.weatherconnectorservice.models.LocationProcessorExtracted;
import com.weather.api.weatherconnectorservice.models.LocationTreeType;
import org.apache.kafka.clients.consumer.ConsumerRecord;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Stream;

public class LocationProcessorServiceImpl implements LocationProcessorService {

    @Override
    public void processLocationAndGetWeather(ConsumerRecord<UUID, Location> consumerRecord) {
        extractLocations(consumerRecord.value());
    }

    private List<LocationProcessorExtracted> extractLocations(final Location location) {
        return Stream.of(Stream.of(extractLocation(location, LocationTreeType.MAIN)),
                        location.nearestLocations()
                                .stream()
                                .map(location1 -> extractLocation(location, LocationTreeType.CHILD)))
                .flatMap(Function.identity())
                .sorted(Comparator.comparing(LocationProcessorExtracted::getType)
                        .reversed()
                        .thenComparing(LocationProcessorExtracted::getDistance))
                .toList();
    }

    private LocationProcessorExtracted extractLocation(final Location location, final LocationTreeType type) {
        return Optional.ofNullable(location)
                .map(location1 -> LocationProcessorExtracted.builder()
                        .type(type)
                        .locationName(location.locationName())
                        .distance(location.distance())
                        .latitude(location.latitude())
                        .longitude(location.longitude())
                        .build())
                .orElse(null);
    }
}
