package com.keyin.rest.airports;

import java.util.List;

import com.keyin.rest.aircraft.Aircraft;
import com.keyin.rest.cities.Cities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;

/**
 * Airport represents an Airport entity in the system that includes the following features:
 * - Airport code, name, and city location
 * - Can track aircraft associated with a specific airport
 * - Mapped to database using JPA, which allows it to be persisted/queried
 */
@Entity
public class Airport {
    @Id
    @SequenceGenerator(name = "airport_sequence", sequenceName = "airport_sequence", allocationSize = 1, initialValue=1)
    @GeneratedValue(generator = "airport_sequence")

    // Storing String objects & primitive data types
    private long id;
    private String code;
    private String name;

    @ManyToOne
    private Cities city; // M@O because an airport is permanently tied to a specific city, and can't move

    @ManyToMany
    private List<Aircraft> aircraft; // @MTM because one plane can land/take off at many different airports

    /* ----------------------- */
    // Accessors/mutators (getters/setters used to access or modify fields of an object)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Cities getCity() {
        return city;
    }

    public void setCity(Cities city) {
        this.city = city;
    }

    public List<Aircraft> getAircraft() {
        return aircraft;
    }

    public void setAircraft(List<Aircraft> aircraft) {
        this.aircraft = aircraft;
    }
}