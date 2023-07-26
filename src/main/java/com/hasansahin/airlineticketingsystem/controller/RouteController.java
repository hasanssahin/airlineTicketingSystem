package com.hasansahin.airlineticketingsystem.controller;

import com.hasansahin.airlineticketingsystem.dto.RouteDto;
import com.hasansahin.airlineticketingsystem.dto.create.RouteCreateDto;
import com.hasansahin.airlineticketingsystem.service.RouteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/routes")
public class RouteController {
	private final RouteService routeService;

	@PostMapping
	public ResponseEntity<RouteDto> save(@RequestBody RouteCreateDto routeCreateDto, @RequestParam String departureAirportIataCode, @RequestParam String arrivalAirportIataCode) {
		return ResponseEntity.ok(routeService.save(routeCreateDto, departureAirportIataCode, arrivalAirportIataCode));
	}
}
