package com.erayserter.flightsearchapi.Flight.models;

import com.erayserter.flightsearchapi.Airport.model.Airport;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import jakarta.validation.constraints.Min;
import lombok.*;
import org.hibernate.annotations.*;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@SQLDelete(sql = "UPDATE airport SET deleted=true WHERE id=?")
@Entity
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne(optional = false)
    @JoinColumn(nullable = false)
    private Airport departureAirport;
    @ManyToOne(optional = false)
    @JoinColumn(nullable = false)
    private Airport arrivalAirport;

    private Date outwardDate;

    private Date returnDate;

    @Min(message = "Price must be non-negative.", value = 0)
    @Column(nullable = false)
    private BigDecimal price;

    @JsonIgnore
    private boolean deleted = false;
}
