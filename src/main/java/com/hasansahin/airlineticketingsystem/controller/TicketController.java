package com.hasansahin.airlineticketingsystem.controller;

import com.hasansahin.airlineticketingsystem.dto.TicketDto;
import com.hasansahin.airlineticketingsystem.dto.create.TicketCreateDto;
import com.hasansahin.airlineticketingsystem.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/tickets")
public class TicketController {
	private final TicketService ticketService;

	@PostMapping
	public ResponseEntity<TicketDto> save(@RequestBody TicketCreateDto ticketDto, @RequestParam String customerEmail, @RequestParam String flightUuid, @RequestParam String cvc) {
		return ResponseEntity.ok(ticketService.save(ticketDto, customerEmail, flightUuid, cvc));
	}

	@GetMapping
	public ResponseEntity<TicketDto> find(@RequestParam String ticketNumber) {
		return ResponseEntity.ok(ticketService.findTicketByUuid(ticketNumber));
	}

	@DeleteMapping
	public ResponseEntity<Void> delete(@RequestParam String ticketNumber) {
		ticketService.deleteTicketByTicketNumber(ticketNumber);
		return ResponseEntity.noContent().build();
	}
}
