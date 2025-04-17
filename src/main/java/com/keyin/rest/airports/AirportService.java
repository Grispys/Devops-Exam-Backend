package com.keyin.rest.airports;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * AirportService, a class handling all Airport data and business logic.
 * This class provides methods to help retrieve, create, update, and search
 * for airports.
 */
@Service // Marks class as a Spring service, used for dependency injection
public class AirportService {
    @Autowired
    private AirportRepository airportRepository; // Inject AirportRepository for DB interaction

    // Retrieve all records in the database for airports
    public List<Airport> findAllAirports() {
        return (List<Airport>) airportRepository.findAll();
    }

    // Retrieve an airport by its ID, return null if no existing data found
    public Airport findAirportById(long id) {
        Optional<Airport> optionalAirport = airportRepository.findById(id);

        return optionalAirport.orElse(null);
    }

    // Search for airport by name
    public Airport findByName(String name) {
        return airportRepository.findByName(name);
    }

    // Create & save new airport data to the DB
    public Airport createAirport(Airport newAirport) {
        return airportRepository.save(newAirport);
    }

    // Update pre-existing info in the DB on a specific airport
    public Airport updateAirport(long id, Airport updatedAirport) {
        Airport airportToUpdate = findAirportById(id);

        if (airportToUpdate != null) {
            airportToUpdate.setCode(updatedAirport.getCode());
            airportToUpdate.setName(updatedAirport.getName());

            return airportRepository.save(airportToUpdate);
        }

        return null;
    }
}