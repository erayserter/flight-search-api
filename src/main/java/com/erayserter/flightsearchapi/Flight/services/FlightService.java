package com.erayserter.flightsearchapi.Flight.services;

import com.erayserter.flightsearchapi.Airport.service.AirportService;
import com.erayserter.flightsearchapi.Flight.dto.FlightQueryRequest;
import com.erayserter.flightsearchapi.Flight.dto.FlightRequest;
import com.erayserter.flightsearchapi.Flight.dto.UpdateFlightRequest;
import com.erayserter.flightsearchapi.Airport.model.Airport;
import com.erayserter.flightsearchapi.Flight.models.Flight;
import com.erayserter.flightsearchapi.Flight.repositories.FlightRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class FlightService {
    private final FlightRepository flightRepository;
    private final AirportService airportService;

    public FlightService(FlightRepository flightRepository, AirportService airportService) {
        this.flightRepository = flightRepository;
        this.airportService = airportService;
    }

    public List<Flight> getAllFlightsWith(FlightQueryRequest flightQueryRequest) {
        Airport departureAirport = null;
        Airport arrivalAirport = null;

        Long departureAirportId = flightQueryRequest.departureAirportId();
        Long arrivalAirportId = flightQueryRequest.arrivalAirportId();
        Date outwardDate = flightQueryRequest.outwardDate();
        Date returnDate = flightQueryRequest.returnDate();

        if (departureAirportId != null)
            departureAirport = airportService.getAirportById(departureAirportId);
        if (arrivalAirportId != null)
            arrivalAirport = airportService.getAirportById(arrivalAirportId);

        return flightRepository.findFlights(
                departureAirport,
                arrivalAirport,
                outwardDate,
                returnDate
        );
    }

    public Flight getFlightById(Long id) {
        return flightRepository.findById(id).orElse(null);
    }

    public Flight createFlight(FlightRequest flightRequest) {
        Airport departureAirport = airportService.getAirportById(flightRequest.departureAirportId());
        Airport arrivalAirport = airportService.getAirportById(flightRequest.arrivalAirportId());

        Flight flight = Flight
                .builder()
                .departureAirport(departureAirport)
                .arrivalAirport(arrivalAirport)
                .outwardDate(flightRequest.outwardDate())
                .returnDate(flightRequest.returnDate())
                .price(flightRequest.price())
                .build();

        return flightRepository.save(flight);
    }

    public void deleteFlightById(Long id) {
        flightRepository.deleteById(id);
    }

    public Flight updateFlight(Long id, UpdateFlightRequest updateFlightRequest) {
        Flight flightToUpdate = flightRepository.findById(id).orElse(null);

        if (flightToUpdate == null) {
            return null;
        }

        if (updateFlightRequest.outwardDate() != null) {
            flightToUpdate.setOutwardDate(updateFlightRequest.outwardDate());
        }

        if (updateFlightRequest.returnDate() != null) {
            flightToUpdate.setReturnDate(updateFlightRequest.returnDate());
        }

        if (updateFlightRequest.price() != null) {
            flightToUpdate.setPrice(updateFlightRequest.price());
        }

        return flightRepository.save(flightToUpdate);
    }
}
