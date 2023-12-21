package com.erayserter.flightsearchapi.repositories;

import com.erayserter.flightsearchapi.models.Airport;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AirportRepository extends JpaRepository<Airport, Long> {
}
