package com.hasansahin.airlineticketingsystem.controller;

import com.hasansahin.airlineticketingsystem.dto.AirportDto;
import com.hasansahin.airlineticketingsystem.service.AirportService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/airports")
public class AirportController {
	private final AirportService airportService;

	@PostMapping
	public ResponseEntity<AirportDto> save(@RequestBody AirportDto airportDto) {
		return ResponseEntity.ok(airportService.save(airportDto));
	}
}
