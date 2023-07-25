package com.hasansahin.airlineticketingsystem.dto.converter;

import com.hasansahin.airlineticketingsystem.dto.FlightDto;
import com.hasansahin.airlineticketingsystem.dto.create.FlightCreateDto;
import com.hasansahin.airlineticketingsystem.model.Flight;
import org.springframework.stereotype.Component;

@Component
public class FlightConverter {
	public Flight convertFlightCreateDtoToFlight(FlightCreateDto flightCreateDto) {
		return new Flight(flightCreateDto.getDepartureDate(), flightCreateDto.getArrivalDate(), flightCreateDto.getPrice(), flightCreateDto.getQuota());
	}

	public FlightDto convertFlightToFlightDto(Flight flight) {
		return new FlightDto(flight.getDepartureDate(), flight.getArrivalDate(), flight.getPrice(), flight.getQuota(), flight.getUuid());
	}
}
