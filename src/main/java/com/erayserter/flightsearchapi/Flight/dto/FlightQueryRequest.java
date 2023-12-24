package com.erayserter.flightsearchapi.Flight.dto;

import com.erayserter.flightsearchapi.Flight.models.Flight;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.Serializable;
import java.util.Date;

/**
 * DTO for {@link Flight}
 */
public record FlightQueryRequest(
        @RequestParam(required = false)
        Long departureAirportId,

        @RequestParam(required = false)
        Long arrivalAirportId,
        @RequestParam(required = false)
        @DateTimeFormat(pattern = "yyyy-MM-dd")
        Date outwardDate,
        @RequestParam(required = false)
        @DateTimeFormat(pattern = "yyyy-MM-dd")
        Date returnDate) implements Serializable {
}