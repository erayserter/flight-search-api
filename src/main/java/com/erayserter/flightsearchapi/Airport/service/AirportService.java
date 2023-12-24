package com.erayserter.flightsearchapi.Airport.service;

import com.erayserter.flightsearchapi.Airport.dto.AirportRequest;
import com.erayserter.flightsearchapi.Airport.model.Airport;
import com.erayserter.flightsearchapi.Airport.repository.AirportRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AirportService {
    private final AirportRepository airportRepository;

    public AirportService(AirportRepository airportRepository) {
        this.airportRepository = airportRepository;
    }

    public List<Airport> getAllAirports() {
        return airportRepository.findAll();
    }

    public Airport getAirportById(Long id) {
        return airportRepository.findById(id).orElse(null);
    }

    public Airport createAirport(AirportRequest airportRequest) {
        Airport airport = Airport
                .builder()
                .city(airportRequest.city())
                .build();

        return airportRepository.save(airport);
    }

    public Airport updateAirport(Long id, AirportRequest airportRequest) {
        Airport airportToUpdate = airportRepository.findById(id).orElse(null);

        if (airportToUpdate == null) {
            return null;
        }

        airportToUpdate.setCity(airportRequest.city());

        return airportRepository.save(airportToUpdate);
    }

    public void deleteAirportById(Long id) {
        airportRepository.deleteById(id);
    }
}
