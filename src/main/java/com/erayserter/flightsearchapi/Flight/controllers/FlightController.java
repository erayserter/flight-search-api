package com.erayserter.flightsearchapi.Flight.controllers;

import com.erayserter.flightsearchapi.Flight.dto.FlightQueryRequest;
import com.erayserter.flightsearchapi.Flight.dto.FlightRequest;
import com.erayserter.flightsearchapi.Flight.dto.UpdateFlightRequest;
import com.erayserter.flightsearchapi.Flight.models.Flight;
import com.erayserter.flightsearchapi.Flight.services.FlightService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/flights")
public class FlightController {
    private final FlightService flightService;

    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    @GetMapping
    public List<Flight> getAllFlights(FlightQueryRequest flightQueryRequest) {
        return flightService.getAllFlightsWith(flightQueryRequest);
    }

    @GetMapping("/{id}")
    public Flight getFlightById(@PathVariable long id) {
        return flightService.getFlightById(id);
    }

    @PostMapping
    public Flight createFlight(@RequestBody FlightRequest flightRequest) {
        return flightService.createFlight(flightRequest);
    }

    @PutMapping("/{id}")
    public Flight updateFlight(@PathVariable Long id, @RequestBody UpdateFlightRequest updateFlightRequest) {
        return flightService.updateFlight(id, updateFlightRequest);
    }

    @DeleteMapping("/{id}")
    public void deleteFlightById(@PathVariable long id) {
        flightService.deleteFlightById(id);
    }
}
