package com.erayserter.flightsearchapi.Flight.dto;

import org.springframework.format.annotation.DateTimeFormat;
import java.math.BigDecimal;
import java.util.Date;

public record UpdateFlightRequest(
        @DateTimeFormat(pattern = "yyyy-MM-dd")
        Date outwardDate,

        @DateTimeFormat(pattern = "yyyy-MM-dd")
        Date returnDate,

        BigDecimal price
) {
}
