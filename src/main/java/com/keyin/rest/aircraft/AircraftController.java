package com.keyin.rest.aircraft;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@RequestMapping("/api")
@RestController
@CrossOrigin
public class AircraftController {
    @Autowired
    private AircraftService aircraftService;

    @GetMapping("/aircrafts")
    public List<Aircraft> getAllAircrafts() {
        return aircraftService.findAllAircrafts();
    }

    @GetMapping("/aircraft/{id}")
    public Aircraft getAircraftByID(@PathVariable long id) {
        return aircraftService.findAircraftById(id);
    }

    @PostMapping("/aircraft_search")
    public List<Aircraft> searchAircrafts(@RequestParam(value = "type", required = false) String type) {
        List<Aircraft> results = new ArrayList<Aircraft>();

        Aircraft aircraft = aircraftService.findByType(type);

        if (aircraft != null) {
            results.add(aircraft);
        }

        return results;
    }

    @PostMapping("/aircraft")
    public Aircraft createAircraft(@RequestBody Aircraft newAircraft) {
        return aircraftService.createAircraft(newAircraft);
    }

    @PutMapping("/aircraft/{id}")
    public Aircraft updateAircraft(@PathVariable long id, @RequestBody Aircraft updatedAircraft) {
        return aircraftService.updateAircraft(id, updatedAircraft);
    }
}