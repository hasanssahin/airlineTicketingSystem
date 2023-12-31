package com.hasansahin.airlineticketingsystem.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@NotBlank
public class AirportDto {
    private String name;
    private String country;
    private String city;
    private String iataCode;
}
