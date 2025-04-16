package com.keyin.rest.cities;

import com.keyin.rest.airports.Airport;
import com.keyin.rest.airports.AirportRepository;
import com.keyin.rest.airports.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@RequestMapping("/api")
@RestController
@CrossOrigin
public class CitiesController {
    @Autowired
    private CitiesService cityService;
    @Autowired
    private AirportRepository airportRepository;

    @GetMapping("/cities")
    public List<Cities> getAllCities() {
        return cityService.findAllCities();
    }

    @GetMapping("/cities/{id}")
    public Cities getCityByID(@PathVariable long id) {
        return cityService.findCityById(id);
    }

    @GetMapping("/city_search")
    public List<Cities> searchCity(@RequestParam(value = "name", required = false) String name) {
        List<Cities> results = new ArrayList<Cities>();

        Cities city = cityService.findByName(name);

        if (city != null) {
            results.add(city);
        }

        return results;
    }

    @PostMapping("/city")
    public Cities createCity(@RequestBody Cities newCity) {
        Airport airport = airportRepository.findById(newCity.getAirport().getId())
                .orElseThrow(() -> new RuntimeException("Airport not found"));

        newCity.setAirport(airport);
        return cityService.createCity(newCity);
    }

    @PutMapping("/city/{id}")
    public Cities updateCity(@PathVariable long id, @RequestBody Cities updatedCity) {
        return cityService.updateCity(id, updatedCity);
    }
}