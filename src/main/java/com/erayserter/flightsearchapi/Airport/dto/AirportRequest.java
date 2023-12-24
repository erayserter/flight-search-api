package com.erayserter.flightsearchapi.Airport.dto;

import jakarta.validation.constraints.NotNull;

import java.io.Serializable;


public record AirportRequest(
        @NotNull
        String city
) implements Serializable {
}