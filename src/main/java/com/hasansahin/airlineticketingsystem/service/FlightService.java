package com.hasansahin.airlineticketingsystem.service;

import com.hasansahin.airlineticketingsystem.dto.FlightDto;
import com.hasansahin.airlineticketingsystem.dto.converter.FlightConverter;
import com.hasansahin.airlineticketingsystem.dto.converter.RouteConverter;
import com.hasansahin.airlineticketingsystem.dto.create.FlightCreateDto;
import com.hasansahin.airlineticketingsystem.model.Airline;
import com.hasansahin.airlineticketingsystem.model.Flight;
import com.hasansahin.airlineticketingsystem.model.Route;
import com.hasansahin.airlineticketingsystem.repository.AirlineRepository;
import com.hasansahin.airlineticketingsystem.repository.FlightRepository;
import com.hasansahin.airlineticketingsystem.repository.RouteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FlightService {
    private final FlightRepository flightRepository;
    private final FlightConverter flightConverter;

    private final RouteService routeService;
    private final AirlineService airlineService;

    public FlightDto save(FlightCreateDto flightCreateDto, String routeUuid, String airlineIataCode) {
        Flight flight = flightConverter.convertFlightCreateDtoToFlight(flightCreateDto);
        Route route = routeService.findByUuidProtected(routeUuid);
        Airline airline = airlineService.findByIataCodeProtected(airlineIataCode);
        flight.setAirline(airline);
        flight.setRoute(route);
        return flightConverter.convertFlightToFlightDto(flightRepository.save(flight));
    }

    public void increaseQuota(String flightUuid, Integer quota) {
        Flight flight = flightRepository.findByUuid(flightUuid);

        if (quota > flight.getQuota() && quota >= flight.getQuota() * 1.10) {
            flight.setPrice((flight.getPrice() * 10 / 100) + flight.getPrice());
        }

        flight.setQuota(quota);
        flightRepository.save(flight);
    }

    public FlightDto findByUuid(String flightUuid) {
        return flightConverter.convertFlightToFlightDto(flightRepository.findByUuid(flightUuid));
    }

    protected Flight findByUuidProtected(String flightUuid) {
        return flightRepository.findByUuid(flightUuid);
    }
}
