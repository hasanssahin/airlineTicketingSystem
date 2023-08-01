package com.hasansahin.airlineticketingsystem.controller;

import com.hasansahin.airlineticketingsystem.dto.RouteDto;
import com.hasansahin.airlineticketingsystem.dto.create.RouteCreateDto;
import com.hasansahin.airlineticketingsystem.service.RouteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/routes")
public class RouteController {
    private final RouteService routeService;

    @PostMapping
    public ResponseEntity<RouteDto> save(@RequestBody @Valid RouteCreateDto routeCreateDto, @RequestParam @Valid String departureAirportIataCode, @RequestParam @Valid String arrivalAirportIataCode) {
        return ResponseEntity.ok(routeService.save(routeCreateDto, departureAirportIataCode, arrivalAirportIataCode));
    }

    @GetMapping
    public ResponseEntity<RouteDto> findByUuid(@RequestParam @Valid String routeUuid) {
        return ResponseEntity.ok(routeService.findByUuid(routeUuid));
    }
}
