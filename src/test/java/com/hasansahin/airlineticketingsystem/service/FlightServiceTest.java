package com.hasansahin.airlineticketingsystem.service;

import com.hasansahin.airlineticketingsystem.dto.AirlineDto;
import com.hasansahin.airlineticketingsystem.dto.FlightDto;
import com.hasansahin.airlineticketingsystem.dto.RouteDto;
import com.hasansahin.airlineticketingsystem.dto.converter.FlightConverter;
import com.hasansahin.airlineticketingsystem.dto.create.FlightCreateDto;
import com.hasansahin.airlineticketingsystem.model.Flight;
import com.hasansahin.airlineticketingsystem.repository.FlightRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Date;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class FlightServiceTest {
    @Mock
    FlightRepository flightRepository;

    @Mock
    FlightConverter flightConverter;

    @Mock
    RouteService routeService;

    @Mock
    AirlineService airlineService;

    @InjectMocks
    FlightService flightService;

    @Test
    void save(){
        AirlineDto airlineDto=new AirlineDto("Airline Name 1","Airline Country 1","1");
        RouteDto routeDto=new RouteDto("Route Name 1","123456789");

        Flight flight=new Flight(new Date(),new Date(),1500.0,10);
        FlightCreateDto flightCreateDto=new FlightCreateDto(new Date(),new Date(),10,1500.0);
        FlightDto flightDto=new FlightDto(new Date(),new Date(),1500.0,10,"123456789");

        when(flightConverter.convertFlightCreateDtoToFlight(flightCreateDto)).thenReturn(flight);
        when(flightConverter.convertFlightToFlightDto(flight)).thenReturn(flightDto);
        when(flightRepository.save(flight)).thenReturn(flight);

        FlightDto resultFlightDto=flightService.save(flightCreateDto,routeDto.getUuid(),airlineDto.getIataCode());

        assertEquals(flightDto.getUuid(),resultFlightDto.getUuid());
    }

    @Test
    void increaseQuota(){
        Flight flight=new Flight(new Date(),new Date(),1500.0,10);
        FlightDto flightDto=new FlightDto(new Date(),new Date(),1500.0,10,"123456789");

        when(flightRepository.findByUuid(flightDto.getUuid())).thenReturn(Optional.of(flight));
        when(flightRepository.save(flight)).thenReturn(flight);

        flightService.increaseQuota("123456789",20);

        assertEquals(20,flight.getQuota());
    }
}
