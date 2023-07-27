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
public class Airline extends AirBaseInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "airline")
    private List<Flight> flights;

    public Airline(String name, String country, String iataCode) {
        super(name, country, iataCode);
    }
}
