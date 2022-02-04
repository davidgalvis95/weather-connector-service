package com.weather.api.weatherconnectorservice.models.location;

import lombok.AllArgsConstructor;
import lombok.Builder;
import java.util.LinkedList;
import java.util.UUID;

@Builder(toBuilder = true)
@AllArgsConstructor
public record Location(UUID id,
                       LocationType type,
                       String locationName,
                       String country,
                       String countryCode,
                       String region,
                       String regionCode,
                       Double latitude,
                       Double longitude,
                       Integer population,
                       Double distance,
                       String postalCode,
                       LinkedList<Location> nearestLocations) {
}
