package com.hasansahin.airlineticketingsystem.service;

import com.hasansahin.airlineticketingsystem.dto.AirlineDto;
import com.hasansahin.airlineticketingsystem.dto.converter.AirlineConverter;
import com.hasansahin.airlineticketingsystem.model.Airline;
import com.hasansahin.airlineticketingsystem.repository.AirlineRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AirlineService {
	private final AirlineConverter airlineConverter;
	private final AirlineRepository airlineRepository;

	//Havayolu şirketi ekle
	public AirlineDto save(AirlineDto airlineDto) {
		Airline airline = airlineRepository.save(airlineConverter.convertAirlineDtoToAirline(airlineDto));
		return airlineConverter.convertAirlineToAirlineDto(airline);
	}

	//Havayolu ara
	public AirlineDto findByIataCode(String iataCode) {
		Airline airline = airlineRepository.findByIataCode(iataCode);
		return airlineConverter.convertAirlineToAirlineDto(airline);
	}
}
