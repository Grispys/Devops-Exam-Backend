package com.keyin.rest.aircraft;

import java.util.List;

import com.keyin.rest.airports.Airport;
import com.keyin.rest.passengers.Passenger;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;

/**
 * Aircraft class represents an aircraft able to carry passengers and fly between airports,
 * and helps to track aircraft details, passenger connections, and airport routes. Mapped to
 * a database with JPA, allowing persistence and querying!
 */
@Entity
public class Aircraft {
    @Id
    @SequenceGenerator(name = "aircraft_sequence", sequenceName = "aircraft_sequence", allocationSize = 1, initialValue=1)
    @GeneratedValue(generator = "aircraft_sequence")

    // Storing String objects & primitive data types
    private long id;
    private String type;
    private String airlineName;
    private int numberOfPassengers;

    @ManyToMany
    private List<Passenger> passengers; // @MTM as an aircraft can hold many passengers/they can fly on multiple planes

    @ManyToMany
    private List<Airport> airports; // @MTM because one plane can land/take off at many different airports

    /* ----------------------- */
    // Accessors/mutators (getters/setters used to access or modify fields of an object)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAirlineName() {
        return airlineName;
    }

    public void setAirlineName(String airlineName) {
        this.airlineName = airlineName;
    }

    public int getNumberOfPassengers() {
        return numberOfPassengers;
    }

    public void setNumberOfPassengers(int numberOfPassengers) {
        this.numberOfPassengers = numberOfPassengers;
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassenger(List<Passenger> passengers) {
        this.passengers = passengers;
    }

    public List<Airport> getAirport() {
        return airports;
    }

    public void setAirport(List<Airport> airport) {
        this.airports = airport;
    }
}