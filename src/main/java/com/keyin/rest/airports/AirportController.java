package com.keyin.rest.airports;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * AirportController is used to handle any aircraft-related API/HTTP requests related
 * to Airport entities.
 */
@RequestMapping("/api") // This is a prefix for all routes in this controller
@RestController // Enables this class to handle REST API endpoints via Spring Boot
@CrossOrigin // Allows Cross-Origin requests, important for the front-end/back-end communication

public class AirportController { // Using @Autowired to inject airport service data
    @Autowired

    private AirportService airportService;

    // Returns all airports
    @GetMapping("/airports")
    public List<Airport> getAllAirports() {
        return airportService.findAllAirports();
    }

    // Returns a single airport by its ID
    @GetMapping("/airport/{id}")
    public Airport getAirportByID(@PathVariable long id) {
        return airportService.findAirportById(id);
    }

    // Search for an airport by name
    @GetMapping("/airport_search")
    public List<Airport> searchAirports(@RequestParam(value = "name", required = false) String name) {
        List<Airport> results = new ArrayList<Airport>();

        Airport airport = airportService.findByName(name);

        if (airport != null) {
            results.add(airport);
        }

        return results;
    }

    /* ----------------------- */
    // Allows user to create new airport
    @PostMapping("/airport")
    public Airport createAirport(@RequestBody Airport newAirport) {
        return airportService.createAirport(newAirport);
    }

    /* ----------------------- */
    // Update existing airport via ID
    @PutMapping("/airport/{id}")
    public Airport updateAirport(@PathVariable long id, @RequestBody Airport updatedAirport) {
        return airportService.updateAirport(id, updatedAirport);
    }
}