package com.hasansahin.airlineticketingsystem.controller;

import com.hasansahin.airlineticketingsystem.dto.AirportDto;
import com.hasansahin.airlineticketingsystem.service.AirportService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/airports")
public class AirportController {
    private final AirportService airportService;

    @PostMapping
    public ResponseEntity<AirportDto> save(@RequestBody @Valid AirportDto airportDto) {
        return ResponseEntity.ok(airportService.save(airportDto));
    }

    @GetMapping
    public ResponseEntity<AirportDto> findByIataCode(@RequestParam @Valid String iataCode) {
        return ResponseEntity.ok(airportService.findByIataCode(iataCode));
    }
}
