package com.erayserter.flightsearchapi.repositories;

import com.erayserter.flightsearchapi.models.Flight;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightRepository extends JpaRepository<Flight, Long> {
}
