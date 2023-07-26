package com.hasansahin.airlineticketingsystem.service;

import com.hasansahin.airlineticketingsystem.dto.FlightDto;
import com.hasansahin.airlineticketingsystem.dto.converter.FlightConverter;
import com.hasansahin.airlineticketingsystem.dto.create.FlightCreateDto;
import com.hasansahin.airlineticketingsystem.model.Airline;
import com.hasansahin.airlineticketingsystem.model.Flight;
import com.hasansahin.airlineticketingsystem.model.Route;
import com.hasansahin.airlineticketingsystem.repository.AirlineRepository;
import com.hasansahin.airlineticketingsystem.repository.FlightRepository;
import com.hasansahin.airlineticketingsystem.repository.RouteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FlightService {
	private final FlightConverter flightConverter;
	private final FlightRepository flightRepository;
	private final RouteRepository routeRepository;
	private final AirlineRepository airlineRepository;

	public FlightDto save(FlightCreateDto flightCreateDto, String routeUuid, String airlineIataCode) {
		Flight flight = flightConverter.convertFlightCreateDtoToFlight(flightCreateDto);
		Route route = routeRepository.findByUuid(routeUuid);
		Airline airline = airlineRepository.findByIataCode(airlineIataCode);
		flight.setAirline(airline);
		flight.setRoute(route);
		return flightConverter.convertFlightToFlightDto(flightRepository.save(flight));
	}

	public void increaseQuota(String flightUuid, Integer quota) {
		Flight flight = flightRepository.findByUuid(flightUuid);

		if (quota > flight.getQuota() && quota >= flight.getQuota() * 1.10) {
			flight.setPrice((flight.getPrice() * 10 / 100) + flight.getPrice());
		}

		flight.setQuota(quota);
		flightRepository.save(flight);
	}

	public FlightDto findByUuid(String flightUuid) {
		return flightConverter.convertFlightToFlightDto(flightRepository.findByUuid(flightUuid));
	}
}
