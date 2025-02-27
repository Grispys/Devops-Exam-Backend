package com.keyin.rest.passengers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@RequestMapping("/api")
@RestController
@CrossOrigin
public class PassengerController {
    @Autowired
    private PassengerService passengerService;

    @GetMapping("/passengers")
    public List<Passenger> getAllPassengers() {
        return passengerService.findAllPassengers();
    }

    @GetMapping("/passenger/{id}")
    public Passenger getPassengerByID(@PathVariable long id) {
        return passengerService.findPassengerById(id);
    }

    @GetMapping("/passenger_search")
    public List<Passenger> searchPassengers(@RequestParam(value = "firstName", required = false) String firstName) {
        List<Passenger> results = new ArrayList<Passenger>();

        Passenger passenger = passengerService.findByFirstName(firstName);

        if (passenger != null) {
            results.add(passenger);
        }

        return results;
    }

    @PostMapping("/passenger")
    public Passenger createPassenger(@RequestBody Passenger newPassenger) {
        return passengerService.createPassenger(newPassenger);
    }

    @PutMapping("/passenger/{id}")
    public Passenger updatePassenger(@PathVariable long id, @RequestBody Passenger updatedPassenger) {
        return passengerService.updatePassenger(id, updatedPassenger);
    }
}