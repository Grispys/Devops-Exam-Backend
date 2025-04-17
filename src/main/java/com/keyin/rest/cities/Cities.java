package com.keyin.rest.cities;

import com.keyin.rest.airports.Airport;
import com.keyin.rest.passengers.Passenger;

import jakarta.persistence.*;

/**
 * Cities represents a city entity, which includes city name, population, alongside associated airport
 * and passengers. The class is also mapped to the database with JPA, to be persisted
 * and queried on.
 */
@Entity
public class Cities {
    @Id
    @SequenceGenerator(name = "city_sequence", sequenceName = "city_sequence", allocationSize = 1, initialValue=1)
    @GeneratedValue(generator = "city_sequence")

    // Storing String objects & primitive data types
    private long id;
    private String name;
    private String state;
    private int population;

    @ManyToOne
    private Airport airport; // M@O because an airport is permanently tied to a specific city, and can't move

    @ManyToOne
    private Passenger passenger; // @MTO since the city just essentially represents where they live

    /* ----------------------- */
    // Accessors/mutators (getters/setters used to access or modify fields of an object)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public Airport getAirport() {
        return airport;
    }

    public void setAirport(Airport airport) {
        this.airport = airport;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }
}
