package com.erayserter.flightsearchapi.repositories;

import com.erayserter.flightsearchapi.models.Airport;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AirportRepository extends JpaRepository<Airport, Long> {
    Optional<Airport> findByCity(String city);
}
