package com.hasansahin.airlineticketingsystem.repository;

import com.hasansahin.airlineticketingsystem.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightRepository extends JpaRepository<Flight, Long> {
	Flight findByUuid(String flightUuid);
}
