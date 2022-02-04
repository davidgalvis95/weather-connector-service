package com.weather.api.weatherconnectorservice.models;

import com.fasterxml.jackson.annotation.JsonValue;

public enum LocationType {
    ADM2, CITY, UNKNOWN;

    @JsonValue
    public static LocationType from(String type) {

        LocationType deserializedType;
        try{
            deserializedType = LocationType.valueOf(type.toUpperCase());
        }catch (IllegalArgumentException exception){
            return LocationType.UNKNOWN;
        }
        return deserializedType;
    }
}
