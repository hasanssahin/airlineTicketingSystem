package com.hasansahin.airlineticketingsystem.dto.converter;

import com.hasansahin.airlineticketingsystem.dto.TicketDto;
import com.hasansahin.airlineticketingsystem.dto.create.TicketCreateDto;
import com.hasansahin.airlineticketingsystem.model.Ticket;
import org.springframework.stereotype.Component;

@Component
public class TicketConverter {
	public Ticket convertTicketDtoToTicket(TicketCreateDto ticketCreateDto) {
		return new Ticket(ticketCreateDto.getSeatNumber());
	}

	public TicketDto convertTicketToTicketDto(Ticket ticket) {
		return new TicketDto(ticket.getSeatNumber(), ticket.getTicketNumber());
	}
}
