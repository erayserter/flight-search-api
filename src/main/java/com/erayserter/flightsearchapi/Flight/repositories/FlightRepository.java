package com.erayserter.flightsearchapi.Flight.repositories;

import com.erayserter.flightsearchapi.Airport.model.Airport;
import com.erayserter.flightsearchapi.Flight.models.Flight;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface FlightRepository extends JpaRepository<Flight, Long> {
    @Override
    @Query("select e from #{#entityName} e where e.deleted=false")
    List<Flight> findAll();

    @Query("SELECT f FROM Flight f WHERE " +
            "(:departureAirport IS NULL OR f.departureAirport = :departureAirport) AND " +
            "(:arrivalAirport IS NULL OR f.arrivalAirport = :arrivalAirport) AND " +
            "(cast(:outwardDate as date) IS NULL OR f.outwardDate = cast(:outwardDate as date)) AND " +
            "(cast(:returnDate as date) IS NULL OR f.returnDate = cast(:returnDate as date)) AND " +
            "f.deleted=false")
    List<Flight> findFlights(@Param("departureAirport") Airport departureAirport,
                             @Param("arrivalAirport") Airport arrivalAirport,
                             @Param("outwardDate") Date outwardDate,
                             @Param("returnDate") Date returnDate);
}
