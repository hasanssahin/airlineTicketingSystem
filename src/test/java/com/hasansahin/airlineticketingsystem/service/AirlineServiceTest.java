package com.hasansahin.airlineticketingsystem.service;

import com.hasansahin.airlineticketingsystem.dto.AirlineDto;
import com.hasansahin.airlineticketingsystem.dto.converter.AirlineConverter;
import com.hasansahin.airlineticketingsystem.model.Airline;
import com.hasansahin.airlineticketingsystem.repository.AirlineRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AirlineServiceTest {
    @Mock
    AirlineConverter airlineConverter;
    @Mock
    AirlineRepository airlineRepository;
    @InjectMocks
    AirlineService airlineService;

    @Test
    void save() {
        Airline airline = new Airline("Airline Name 1", "Airline Country 1", "1");
        AirlineDto airlineDto = new AirlineDto("Airline Name 1", "Airline Country 1", "1");

        when(airlineConverter.convertAirlineDtoToAirline(airlineDto)).thenReturn(airline);
        when(airlineConverter.convertAirlineToAirlineDto(airline)).thenReturn(airlineDto);
        when(airlineRepository.save(airline)).thenReturn(airline);

        AirlineDto resultAirlineDto = airlineService.save(airlineDto);

        assertEquals(airline.getIataCode(), resultAirlineDto.getIataCode());
    }

    @Test
    void findByIataCode() {
        Airline airline = new Airline("Airline Name 1", "Airline Country 1", "1");
        AirlineDto airlineDto = new AirlineDto("Airline Name 1", "Airline Country 1", "1");

        when(airlineRepository.findByIataCode(airlineDto.getIataCode())).thenReturn(Optional.of(airline));
        when(airlineConverter.convertAirlineToAirlineDto(airline)).thenReturn(airlineDto);

        AirlineDto resultAirlineDto = airlineService.findByIataCode("1");

        assertEquals(airlineDto.getIataCode(), resultAirlineDto.getIataCode());
    }
}
