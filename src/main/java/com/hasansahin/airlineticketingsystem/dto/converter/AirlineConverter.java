package com.hasansahin.airlineticketingsystem.dto.converter;

import com.hasansahin.airlineticketingsystem.dto.AirlineDto;
import com.hasansahin.airlineticketingsystem.model.Airline;
import org.springframework.stereotype.Component;

@Component
public class AirlineConverter {
	public Airline convertAirlineDtoToAirline(AirlineDto airlineDto) {
		return new Airline(airlineDto.getName(), airlineDto.getCountry(), airlineDto.getIataCode());
	}

	public AirlineDto convertAirlineToAirlineDto(Airline airline) {
		return new AirlineDto(airline.getName(), airline.getCountry(), airline.getIataCode());
	}
}
