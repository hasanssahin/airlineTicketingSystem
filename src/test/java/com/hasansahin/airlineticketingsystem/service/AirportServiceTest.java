package com.hasansahin.airlineticketingsystem.service;

import com.hasansahin.airlineticketingsystem.dto.AirportDto;
import com.hasansahin.airlineticketingsystem.dto.converter.AirportConverter;
import com.hasansahin.airlineticketingsystem.model.Airport;
import com.hasansahin.airlineticketingsystem.repository.AirportRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AirportServiceTest {
    @Mock
    AirportConverter airportConverter;

    @Mock
    AirportRepository airportRepository;

    @InjectMocks
    AirportService airportService;

    @Test
    void save(){
        Airport airport=new Airport("Airport Name 1","Airport Country 1","Airport City 1","1");
        AirportDto airportDto=new AirportDto("Airport Name 1","Airport Country 1","Airport City 1","1");

        when(airportRepository.save(airport)).thenReturn(airport);
        when(airportConverter.convertAirportToAirportDto(airport)).thenReturn(airportDto);
        when(airportConverter.convertAirportDtoToAirport(airportDto)).thenReturn(airport);

        AirportDto resultAirportDto=airportService.save(airportDto);

        assertEquals(airportDto.getIataCode(),resultAirportDto.getIataCode());
    }

    @Test
    void findByIataCode(){
        Airport airport=new Airport("Airport Name 1","Airport Country 1","Airport City 1","1");
        AirportDto airportDto=new AirportDto("Airport Name 1","Airport Country 1","Airport City 1","1");

        when(airportRepository.findByIataCode("1")).thenReturn(airport);
        when(airportConverter.convertAirportToAirportDto(airport)).thenReturn(airportDto);

        AirportDto resultAirportDto=airportService.findByIataCode("1");

        assertEquals(airportDto.getName(),resultAirportDto.getName());
    }
}
