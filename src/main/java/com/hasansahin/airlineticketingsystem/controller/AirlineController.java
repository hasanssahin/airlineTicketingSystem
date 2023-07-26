package com.hasansahin.airlineticketingsystem.controller;

import com.hasansahin.airlineticketingsystem.dto.AirlineDto;
import com.hasansahin.airlineticketingsystem.service.AirlineService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/airlines")
public class AirlineController {
	private final AirlineService airlineService;

	@PostMapping
	public ResponseEntity<AirlineDto> save(@RequestBody AirlineDto airlineDto) {
		return ResponseEntity.ok(airlineService.save(airlineDto));
	}

	@GetMapping
	public ResponseEntity<AirlineDto> findByIataCode(String iataCode) {
		return ResponseEntity.ok(airlineService.findByIataCode(iataCode));
	}
}
