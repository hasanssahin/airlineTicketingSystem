package com.hasansahin.airlineticketingsystem.service;

import com.hasansahin.airlineticketingsystem.dto.TicketDto;
import com.hasansahin.airlineticketingsystem.dto.converter.TicketConverter;
import com.hasansahin.airlineticketingsystem.dto.create.TicketCreateDto;
import com.hasansahin.airlineticketingsystem.model.Ticket;
import com.hasansahin.airlineticketingsystem.repository.TicketRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TicketServiceTest {
    @Mock
    TicketRepository ticketRepository;
    @Mock
    TicketConverter ticketConverter;
    @Mock
    CustomerService customerService;
    @Mock
    FlightService flightService;
    @Mock
    CreditCardService creditCardService;
    @InjectMocks
    TicketService ticketService;


    @Test
    void save(){
        TicketCreateDto ticketCreateDto=new TicketCreateDto(3);
        Ticket ticket=new Ticket(3);
        TicketDto ticketDto=new TicketDto(3,"123");

        when(ticketConverter.convertTicketDtoToTicket(ticketCreateDto)).thenReturn(ticket);
        when(ticketConverter.convertTicketToTicketDto(ticket)).thenReturn(ticketDto);
        when(ticketRepository.save(ticket)).thenReturn(ticket);

        TicketDto resultTicketDto=ticketService.save(ticketCreateDto,"hasansahin@gmail.com","123456789","546");

        assertEquals(ticketDto.getTicketNumber(),resultTicketDto.getTicketNumber());
    }

    @Test
    void findTicketByUuid(){
        Ticket ticket=new Ticket(3);
        TicketDto ticketDto=new TicketDto(3,"123");

        when(ticketConverter.convertTicketToTicketDto(ticket)).thenReturn(ticketDto);
        when(ticketRepository.findByTicketNumber(ticketDto.getTicketNumber())).thenReturn(Optional.of(ticket));

        TicketDto resultTicketDto=ticketService.findTicketByUuid("123");

        assertEquals(ticketDto.getTicketNumber(),resultTicketDto.getTicketNumber());
    }
}
