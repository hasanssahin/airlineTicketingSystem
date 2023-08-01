package com.hasansahin.airlineticketingsystem.service;

import com.hasansahin.airlineticketingsystem.dto.RouteDto;
import com.hasansahin.airlineticketingsystem.dto.converter.RouteConverter;
import com.hasansahin.airlineticketingsystem.dto.create.RouteCreateDto;
import com.hasansahin.airlineticketingsystem.model.Route;
import com.hasansahin.airlineticketingsystem.repository.RouteRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RouteServiceTest {
    @Mock
    RouteConverter routeConverter;

    @Mock
    RouteRepository routeRepository;

    @Mock
    AirportService airportService;

    @InjectMocks
    RouteService routeService;

    @Test
    void save(){
        Route route=new Route("Route Name 1");
        RouteCreateDto routeCreateDto=new RouteCreateDto("Route Name 1");
        RouteDto routeDto=new RouteDto("Route Name 1","123456789");

        when(routeConverter.convertRouteCreateDtoToRoute(routeCreateDto)).thenReturn(route);
        when(routeRepository.save(route)).thenReturn(route);
        when(routeConverter.convertRouteToRouteDto(route)).thenReturn(routeDto);

        RouteDto resultRouteDto=routeService.save(routeCreateDto,"1","2");

        assertEquals(routeDto.getUuid(),resultRouteDto.getUuid());
    }

    @Test
    void findByUuid(){
        Route route=new Route("Route Name 1");
        RouteDto routeDto=new RouteDto("Route Name 1","123456789");

        when(routeRepository.findByUuid(routeDto.getUuid())).thenReturn(route);
        when(routeConverter.convertRouteToRouteDto(route)).thenReturn(routeDto);

        RouteDto resultRouteDto=routeService.findByUuid("123456789");

        assertEquals(routeDto.getUuid(),resultRouteDto.getUuid());
    }
}
