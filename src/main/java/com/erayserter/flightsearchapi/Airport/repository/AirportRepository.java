package com.erayserter.flightsearchapi.Airport.repository;

import com.erayserter.flightsearchapi.Airport.model.Airport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface AirportRepository extends JpaRepository<Airport, Long> {
    @Override
    @Query("select e from #{#entityName} e where e.deleted=false")
    List<Airport> findAll();
}
