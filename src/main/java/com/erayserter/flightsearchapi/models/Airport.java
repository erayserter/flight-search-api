package com.erayserter.flightsearchapi.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;
import org.hibernate.annotations.SQLDelete;

@Getter
@Setter
@ToString
@Entity
@SQLDelete(sql = "UPDATE flight SET deleted = true WHERE id = ?")
@FilterDef(name = "deletedAirportFilter", parameters = @ParamDef(name = "isDeleted", type = boolean.class))
@Filter(name = "deletedAirportFilter", condition = "deleted = :isDeleted")
public class Airport {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String city;

    private boolean deleted = false;
}
