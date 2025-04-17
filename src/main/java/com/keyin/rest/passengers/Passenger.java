package com.keyin.rest.passengers;

// Imports list
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
 * Passenger represents a passenger entity. This class lists personal details
 * of any passengers, including their:
 * - Name (both first and last)
 * - Phone number
 * And tracks information based on which aircraft the passenger has traveled on,
 * and which city they live in. Mapped to database with JPA.
 */
@Entity
public class Passenger {
    @Id
    @SequenceGenerator(name = "passenger_sequence", sequenceName = "passenger_sequence", allocationSize = 1, initialValue=1)
    @GeneratedValue(generator = "passenger_sequence")

    // Storing String objects & primitive data types
    private long id;
    private String firstName;
    private String lastName;
    private String phoneNumber;

    @ManyToMany
    private List<Aircraft> aircraft; // @MTM as a passenger can board as many flights as they'd like

    @ManyToOne
    private Cities city; // @MTO to describe their starting point, i.e: where they grew up/lived

    /* ----------------------- */
    // Accessors/mutators (getters/setters used to access or modify fields of an object)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<Aircraft> getAircraft() {
        return aircraft;
    }

    public void setAircraft(List<Aircraft> aircraft) {
        this.aircraft = aircraft;
    }

    public Cities getCity() {
        return city;
    }

    public void setCity(Cities city) {
        this.city = city;
    }
}