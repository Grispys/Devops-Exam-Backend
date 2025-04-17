package com.keyin.rest.cities;

import com.keyin.rest.airports.Airport;
import com.keyin.rest.airports.AirportRepository;
import com.keyin.rest.airports.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * CitiesController handles city-related API/HTTP requests related
 * to Cities entities.
 */
@RequestMapping("/api") // This is a prefix for all routes in this controller
@RestController // Enables this class to handle REST API endpoints via Spring Boot
@CrossOrigin // Allows Cross-Origin requests, important for the front-end/back-end communication

public class CitiesController { // Using @Autowired to inject city & airport related data
    @Autowired
    private CitiesService cityService;
    @Autowired
    private AirportRepository airportRepository;

    // Retrieve all cities
    @GetMapping("/cities")
    public List<Cities> getAllCities() {
        return cityService.findAllCities();
    }

    // City name by ID
    @GetMapping("/cities/{id}")
    public Cities getCityByID(@PathVariable long id) {
        return cityService.findCityById(id);
    }

    // Search for a specific city by its name
    @GetMapping("/city_search")
    public List<Cities> searchCity(@RequestParam(value = "name", required = false) String name) {
        List<Cities> results = new ArrayList<Cities>();

        Cities city = cityService.findByName(name);

        if (city != null) {
            results.add(city);
        }

        return results;
    }

    /* ----------------------- */
    // Create a new city using this method
    @PostMapping("/city")
    public Cities createCity(@RequestBody Cities newCity) {
        Airport airport = airportRepository.findById(newCity.getAirport().getId())
                .orElseThrow(() -> new RuntimeException("Airport not found"));

        newCity.setAirport(airport);
        return cityService.createCity(newCity);
    }

    /* ----------------------- */
    // Update information on a given city
    @PutMapping("/city/{id}")
    public Cities updateCity(@PathVariable long id, @RequestBody Cities updatedCity) {
        return cityService.updateCity(id, updatedCity);
    }
}