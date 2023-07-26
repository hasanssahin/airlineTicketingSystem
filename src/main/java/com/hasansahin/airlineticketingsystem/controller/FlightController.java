package com.hasansahin.airlineticketingsystem.controller;

import com.hasansahin.airlineticketingsystem.dto.FlightDto;
import com.hasansahin.airlineticketingsystem.dto.create.FlightCreateDto;
import com.hasansahin.airlineticketingsystem.service.FlightService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/flights")
public class FlightController {
	private final FlightService flightService;

	@PostMapping
	public ResponseEntity<FlightDto> save(@RequestBody FlightCreateDto flightCreateDto, @RequestParam String routeUuid, @RequestParam String airlineIataCode) {
		return ResponseEntity.ok(flightService.save(flightCreateDto, routeUuid, airlineIataCode));
	}

	@PutMapping
	public ResponseEntity<Void> increaseQuota(@RequestParam String flightUuid, Integer quota) {
		flightService.increaseQuota(flightUuid, quota);
		return ResponseEntity.noContent().build();
	}
}
