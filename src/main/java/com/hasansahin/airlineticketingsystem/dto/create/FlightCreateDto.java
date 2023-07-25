package com.hasansahin.airlineticketingsystem.dto.create;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@NotBlank
public class FlightCreateDto {
	private Date departureDate;
	private Date arrivalDate;
	private Double price;
}
