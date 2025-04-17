package com.keyin.rest.aircraft;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * AircraftController is used to handle any aircraft-related API/HTTP requests related
 * to Aircraft entities.
 */
@RequestMapping("/api") // This is a prefix for all routes in this controller
@RestController // Enables this class to handle REST API endpoints via Spring Boot
@CrossOrigin // Allows Cross-Origin requests, important for the front-end/back-end communication

public class AircraftController { // Using @Autowired to inject aircraft service data
    @Autowired
    private AircraftService aircraftService;

    // Using this method retrieves & returns a list of all aircraft in the system
    @GetMapping("/aircrafts")
    public List<Aircraft> getAllAircrafts() {
        return aircraftService.findAllAircrafts();
    }

    // Specifies that you want to retrieve a single aircraft based on its ID (i.e: 1, 2, 3)
    @GetMapping("/aircraft/{id}")
    public Aircraft getAircraftByID(@PathVariable long id) {
        return aircraftService.findAircraftById(id);
    }

    /* ----------------------- */
    // Searches for aircraft by type, will return a list with a single result (if found)
    @PostMapping("/aircraft_search")
    public List<Aircraft> searchAircrafts(@RequestParam(value = "type", required = false) String type) {
        List<Aircraft> results = new ArrayList<Aircraft>();

        Aircraft aircraft = aircraftService.findByType(type);

        if (aircraft != null) {
            results.add(aircraft);
        }

        return results;
    }

    // Creates a new aircraft to store within the database
    @PostMapping("/aircraft")
    public Aircraft createAircraft(@RequestBody Aircraft newAircraft) {
        return aircraftService.createAircraft(newAircraft);
    }

    /* ----------------------- */
    // Update credentials of an existing aircraft
    @PutMapping("/aircraft/{id}")
    public Aircraft updateAircraft(@PathVariable long id, @RequestBody Aircraft updatedAircraft) {
        return aircraftService.updateAircraft(id, updatedAircraft);
    }
}