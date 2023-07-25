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
public class Route {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String routeName;
	private String uuid;

	@OneToOne
	@JoinColumn(name = "departureAirportId")
	private Airport departureAirport;

	@OneToOne
	@JoinColumn(name = "arrivalAirportId")
	private Airport arrivalAirport;

	public Route(String routeName) {
		this.routeName = routeName;
		this.uuid = UUID.randomUUID().toString();
	}
}
