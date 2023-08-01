package com.hasansahin.airlineticketingsystem.repository;

import com.hasansahin.airlineticketingsystem.model.Airport;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AirportRepository extends JpaRepository<Airport, Long> {
    Optional<Airport> findByIataCode(String iataCode);
}
