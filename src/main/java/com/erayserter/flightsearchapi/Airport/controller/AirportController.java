package com.erayserter.flightsearchapi.Airport.controller;

import com.erayserter.flightsearchapi.Airport.dto.AirportRequest;
import com.erayserter.flightsearchapi.Airport.model.Airport;
import com.erayserter.flightsearchapi.Airport.service.AirportService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/airports")
public class AirportController {
    private final AirportService airportService;

    public AirportController(AirportService airportService) {
        this.airportService = airportService;
    }

    @GetMapping
    public List<Airport> getAllAirports() {
        return airportService.getAllAirports();
    }

    @GetMapping("/{id}")
    public Airport getAirportById(@PathVariable Long id) {
        return airportService.getAirportById(id);
    }

    @PostMapping
    public Airport createAirport(@RequestBody AirportRequest airportRequest) {
        return airportService.createAirport(airportRequest);
    }

    @PutMapping("/{id}")
    public Airport updateAirport(@PathVariable Long id, @RequestBody AirportRequest airportRequest) {
        return airportService.updateAirport(id, airportRequest);
    }

    @DeleteMapping("/{id}")
    public void deleteAirportById(@PathVariable Long id) {
        airportService.deleteAirportById(id);
    }
}
