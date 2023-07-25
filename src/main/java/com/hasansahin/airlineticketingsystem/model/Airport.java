package com.hasansahin.airlineticketingsystem.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Airport {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;
	private String country;
	private String city;
	private String iataCode;
	public Airport(String name, String country, String city, String iataCode) {
		this.name = name;
		this.country = country;
		this.city = city;
		this.iataCode = iataCode;
	}
}
