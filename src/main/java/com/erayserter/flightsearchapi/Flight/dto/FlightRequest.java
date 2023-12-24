package com.erayserter.flightsearchapi.Flight.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;
import java.math.BigDecimal;
import java.util.Date;

public record FlightRequest(
        @NotNull
        long departureAirportId,
        @NotNull
        long arrivalAirportId,

        @NotNull
        @DateTimeFormat(pattern = "yyyy-MM-dd")
        Date outwardDate,
        @DateTimeFormat(pattern = "yyyy-MM-dd")
        Date returnDate,

        @NotNull
        @Size(message = "Price must be greater than non-negative.")
        BigDecimal price
) {
}
