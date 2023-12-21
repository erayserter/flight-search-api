package com.erayserter.flightsearchapi.services;

import com.erayserter.flightsearchapi.models.Flight;
import com.erayserter.flightsearchapi.repositories.FlightRepository;

import java.util.List;

public class FlightService {
    FlightRepository flightRepository;

    public FlightService(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    public List<Flight> getAllFlights() {
        return flightRepository.findAll();
    }

    public Flight getFlightById(Long id) {
        return flightRepository.findById(id).orElse(null);
    }

    public Flight createFlight(Flight flight) {
        return flightRepository.save(flight);
    }

    public Flight updateFlight(Long id, Flight flight) {
        Flight flightToUpdate = flightRepository.findById(id).orElse(null);

        if (flightToUpdate == null) {
            return null;
        }

        flightToUpdate.setDepartureAirport(flight.getDepartureAirport());
        flightToUpdate.setArrivalAirport(flight.getArrivalAirport());
        flightToUpdate.setDepartureDate(flight.getDepartureDate());
        flightToUpdate.setArrivalDate(flight.getArrivalDate());
        flightToUpdate.setPrice(flight.getPrice());

        return flightRepository.save(flightToUpdate);
    }

    public void deleteFlightById(Long id) {
        flightRepository.deleteById(id);
    }
}
