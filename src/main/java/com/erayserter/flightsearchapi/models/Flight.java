package com.erayserter.flightsearchapi.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@ToString
@Entity
public class Flight {
    @Id
    @Column(nullable = false)
    private long id;

    @OneToOne(cascade = CascadeType.ALL, optional = false, orphanRemoval = true)
    @JoinColumn(nullable = false)
    private Airport departureAirport;
    @OneToOne(cascade = CascadeType.ALL, optional = false, orphanRemoval = true)
    @JoinColumn(nullable = false)
    private Airport arrivalAirport;

    private Date departureDate;
    private Date arrivalDate;

    private BigDecimal price;
}
