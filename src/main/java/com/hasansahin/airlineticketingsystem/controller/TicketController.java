package com.hasansahin.airlineticketingsystem.controller;

import com.hasansahin.airlineticketingsystem.dto.TicketDto;
import com.hasansahin.airlineticketingsystem.dto.create.TicketCreateDto;
import com.hasansahin.airlineticketingsystem.service.TicketService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/tickets")
public class TicketController {
    private final TicketService ticketService;

    @PostMapping
    public ResponseEntity<TicketDto> save(@RequestBody @Valid TicketCreateDto ticketCreateDto, @RequestParam @Valid String customerEmail, @RequestParam @Valid String flightUuid, @RequestParam @Valid String cvc) {
        return ResponseEntity.ok(ticketService.save(ticketCreateDto, customerEmail, flightUuid, cvc));
    }

    @GetMapping
    public ResponseEntity<TicketDto> find(@RequestParam @Valid String ticketNumber) {
        return ResponseEntity.ok(ticketService.findTicketByUuid(ticketNumber));
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(@RequestParam @Valid String ticketNumber) {
        ticketService.deleteTicketByTicketNumber(ticketNumber);
        return ResponseEntity.noContent().build();
    }
}
