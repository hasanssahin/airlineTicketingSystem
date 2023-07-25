package com.hasansahin.airlineticketingsystem.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Airline {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;
	private String country;
	private String iataCode;

	@OneToMany(mappedBy = "airline")
	private List<Flight> flights;

	public Airline(String name, String country, String iataCode) {
		this.name = name;
		this.country = country;
		this.iataCode = iataCode;
	}
}
