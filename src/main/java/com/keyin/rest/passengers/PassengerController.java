package com.keyin.rest.passengers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * PassengerController handles people-related API/HTTP requests related
 * to the Passenger entities. This includes their first and last name,
 * and their phone number.
 */
@RequestMapping("/api") // This is a prefix for all routes in this controller
@RestController // Enables this class to handle REST API endpoints via Spring Boot
@CrossOrigin // Allows Cross-Origin requests, important for the front-end/back-end communication

public class PassengerController { // Using @Autowired to inject city & airport related data
    @Autowired
    private PassengerService passengerService;

    // Nab list of all passengers in the DB
    @GetMapping("/passengers")
    public List<Passenger> getAllPassengers() {
        return passengerService.findAllPassengers();
    }

    // Search for your favourite person by their ID
    @GetMapping("/passenger/{id}")
    public Passenger getPassengerByID(@PathVariable long id) {
        return passengerService.findPassengerById(id);
    }

    // Alternatively, search for them by name
    @GetMapping("/passenger_search")
    public List<Passenger> searchPassengers(@RequestParam(value = "firstName", required = false) String firstName) {
        List<Passenger> results = new ArrayList<Passenger>();

        Passenger passenger = passengerService.findByFirstName(firstName);

        if (passenger != null) {
            results.add(passenger);
        }

        return results;
    }

    /* ----------------------- */
    // Create information on a new passenger
    @PostMapping("/passenger")
    public Passenger createPassenger(@RequestBody Passenger newPassenger) {
        return passengerService.createPassenger(newPassenger);
    }

    /* ----------------------- */
    // Update a passengers information
    @PutMapping("/passenger/{id}")
    public Passenger updatePassenger(@PathVariable long id, @RequestBody Passenger updatedPassenger) {
        return passengerService.updatePassenger(id, updatedPassenger);
    }
}