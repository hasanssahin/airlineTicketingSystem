package com.hasansahin.airlineticketingsystem.dto.converter;

import com.hasansahin.airlineticketingsystem.dto.AirportDto;
import com.hasansahin.airlineticketingsystem.model.Airport;
import org.springframework.stereotype.Component;

@Component
public class AirportConverter {
	public Airport convertAirportDtoToAirport(AirportDto airportDto){
		return new Airport(airportDto.getName(), airportDto.getCountry(), airportDto.getCity(), airportDto.getIataCode());
	}

	public AirportDto convertAirportToAirportDto(Airport airport){
		return new AirportDto(airport.getName(), airport.getCountry(), airport.getCity(), airport.getIataCode());
	}
}
