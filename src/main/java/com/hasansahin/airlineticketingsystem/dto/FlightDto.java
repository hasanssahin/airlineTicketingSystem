package com.hasansahin.airlineticketingsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FlightDto {
	private Date departureDate;
	private Date arrivalDate;
	private Double price;
	private Integer quota;
	private String uuid;
}
