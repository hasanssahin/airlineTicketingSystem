package com.hasansahin.airlineticketingsystem.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Temporal(TemporalType.DATE)
    private Date departureDate;
    @Temporal(TemporalType.DATE)
    private Date arrivalDate;
    private Double price;
    private Integer quota;
    private String uuid;

    @ManyToOne
    private Airline airline;

    @OneToOne
    private Route route;

    public Flight(Date departureDate, Date arrivalDate, Double price, Integer quota) {
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
        this.price = price;
        this.quota = quota;
        this.uuid = UUID.randomUUID().toString();
    }
}