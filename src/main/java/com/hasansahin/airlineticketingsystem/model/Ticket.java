package com.hasansahin.airlineticketingsystem.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Ticket {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Integer seatNumber;
	private String ticketNumber;

	@ManyToOne
	private Customer customer;

	@OneToOne
	private Flight flight;

	@OneToOne
	private CreditCard creditCard;

	public Ticket(Integer seatNumber) {
		this.seatNumber = seatNumber;
		this.ticketNumber= UUID.randomUUID().toString();
	}
}