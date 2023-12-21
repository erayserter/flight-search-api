package com.erayserter.flightsearchapi.services;

import com.erayserter.flightsearchapi.models.Airport;
import com.erayserter.flightsearchapi.repositories.AirportRepository;

import java.util.List;

public class AirportService {
    public AirportRepository airportRepository;

    public AirportService(AirportRepository airportRepository) {
        this.airportRepository = airportRepository;
    }

    public List<Airport> getAllAirports() {
        return airportRepository.findAll();
    }

    public Airport getAirportById(Long id) {
        return airportRepository.findById(id).orElse(null);
    }

    public Airport createAirport(Airport airport) {
        return airportRepository.save(airport);
    }

    public Airport updateAirport(Long id, Airport airport) {
        Airport airportToUpdate = airportRepository.findById(id).orElse(null);

        if (airportToUpdate == null) {
            return null;
        }

        airportToUpdate.setCity(airport.getCity());

        return airportRepository.save(airportToUpdate);
    }

    public void deleteAirportById(Long id) {
        airportRepository.deleteById(id);
    }
}
