package com.hasansahin.airlineticketingsystem.service;

import com.hasansahin.airlineticketingsystem.dto.AirportDto;
import com.hasansahin.airlineticketingsystem.dto.converter.AirportConverter;
import com.hasansahin.airlineticketingsystem.model.Airport;
import com.hasansahin.airlineticketingsystem.repository.AirportRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AirportService {
    private final AirportConverter airportConverter;
    private final AirportRepository airportRepository;

    public AirportDto save(AirportDto airportDto) {
        Airport airport = airportRepository.save(airportConverter.convertAirportDtoToAirport(airportDto));
        return airportConverter.convertAirportToAirportDto(airport);
    }

    public AirportDto findByIataCode(String iataCode) {
        Airport airport = airportRepository.findByIataCode(iataCode);
        return airportConverter.convertAirportToAirportDto(airport);
    }

    protected Airport findByIataCodeProtected(String iataCode) {
        return airportRepository.findByIataCode(iataCode);
    }
}
