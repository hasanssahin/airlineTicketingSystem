package com.hasansahin.airlineticketingsystem.service;

import com.hasansahin.airlineticketingsystem.dto.TicketDto;
import com.hasansahin.airlineticketingsystem.dto.converter.TicketConverter;
import com.hasansahin.airlineticketingsystem.dto.create.TicketCreateDto;
import com.hasansahin.airlineticketingsystem.model.Ticket;
import com.hasansahin.airlineticketingsystem.repository.CreditCardRepository;
import com.hasansahin.airlineticketingsystem.repository.CustomerRepository;
import com.hasansahin.airlineticketingsystem.repository.FlightRepository;
import com.hasansahin.airlineticketingsystem.repository.TicketRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TicketService {
    private final TicketRepository ticketRepository;
    private final TicketConverter ticketConverter;
    private final CustomerService customerService;
    private final FlightService flightService;
    private final CreditCardService creditCardService;

    public TicketDto save(TicketCreateDto ticketCreateDto, String customerEmail, String flightUuid, String cvc) {
        Ticket ticket = ticketConverter.convertTicketDtoToTicket(ticketCreateDto);
        ticket.setCustomer(customerService.findByEmailProtected(customerEmail));
        ticket.setFlight(flightService.findByUuidProtected(flightUuid));
        ticket.setCreditCard(creditCardService.findByCvcProtected(cvc));
        return ticketConverter.convertTicketToTicketDto(ticketRepository.save(ticket));
    }

    public TicketDto findTicketByUuid(String ticketNumber) {
        return ticketConverter.convertTicketToTicketDto(ticketRepository.findByTicketNumber(ticketNumber));
    }

    @Transactional
    public void deleteTicketByTicketNumber(String ticketNumber) {
        ticketRepository.deleteByTicketNumber(ticketNumber);
    }

}
