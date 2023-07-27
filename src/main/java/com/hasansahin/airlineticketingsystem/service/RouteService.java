package com.hasansahin.airlineticketingsystem.service;

import com.hasansahin.airlineticketingsystem.dto.RouteDto;
import com.hasansahin.airlineticketingsystem.dto.converter.RouteConverter;
import com.hasansahin.airlineticketingsystem.dto.create.RouteCreateDto;
import com.hasansahin.airlineticketingsystem.model.Route;
import com.hasansahin.airlineticketingsystem.repository.AirportRepository;
import com.hasansahin.airlineticketingsystem.repository.RouteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RouteService {
    private final RouteConverter routeConverter;
    private final RouteRepository routeRepository;
    private final AirportService airportService;

    public RouteDto save(RouteCreateDto routeCreateDto, String departureAirportIataCode, String arrivalAirportIataCode) {
        Route route = routeConverter.convertRouteCreateDtoToRoute(routeCreateDto);
        route.setDepartureAirport(airportService.findByIataCodeProtected(departureAirportIataCode));
        route.setArrivalAirport(airportService.findByIataCodeProtected(arrivalAirportIataCode));
        return routeConverter.convertRouteToRouteDto(routeRepository.save(route));
    }

    public RouteDto findByUuid(String routeUuid) {
        return routeConverter.convertRouteToRouteDto(routeRepository.findByUuid(routeUuid));
    }

    protected Route findByUuidProtected(String routeUuid) {
        return routeRepository.findByUuid(routeUuid);
    }
}