package com.hasansahin.airlineticketingsystem.service;

import com.hasansahin.airlineticketingsystem.dto.AirlineDto;
import com.hasansahin.airlineticketingsystem.dto.converter.AirlineConverter;
import com.hasansahin.airlineticketingsystem.exception.GenericException;
import com.hasansahin.airlineticketingsystem.model.Airline;
import com.hasansahin.airlineticketingsystem.repository.AirlineRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AirlineService {
    private final AirlineConverter airlineConverter;
    private final AirlineRepository airlineRepository;

    public AirlineDto save(AirlineDto airlineDto) {
        Airline airline = airlineRepository.save(airlineConverter.convertAirlineDtoToAirline(airlineDto));
        return airlineConverter.convertAirlineToAirlineDto(airline);
    }

    public AirlineDto findByIataCode(String iataCode) {
        Airline airline = airlineRepository.findByIataCode(iataCode).orElseThrow(() -> new GenericException("Airline not found", HttpStatus.NOT_FOUND));
        return airlineConverter.convertAirlineToAirlineDto(airline);
    }

    protected Airline findByIataCodeProtected(String iataCode) {
        return airlineRepository.findByIataCode(iataCode).orElseThrow(() -> new GenericException("Airline not found", HttpStatus.NOT_FOUND));
    }

}
