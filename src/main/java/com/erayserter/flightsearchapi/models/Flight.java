package com.erayserter.flightsearchapi.models;

import jakarta.persistence.*;

import jakarta.persistence.CascadeType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.*;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@ToString
@Entity
@SQLDelete(sql = "UPDATE flight SET deleted = true WHERE id = ?")
@FilterDef(name = "deletedFlightFilter", parameters = @ParamDef(name = "isDeleted", type = boolean.class))
@Filter(name = "deletedFlightFilter", condition = "deleted = :isDeleted")
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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

    private boolean deleted = false;
}
