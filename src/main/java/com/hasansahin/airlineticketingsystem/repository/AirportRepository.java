package com.hasansahin.airlineticketingsystem.repository;

import com.hasansahin.airlineticketingsystem.model.Airport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirportRepository extends JpaRepository<Airport, Long> {
	Airport findByIataCode(String iataCode);
}
