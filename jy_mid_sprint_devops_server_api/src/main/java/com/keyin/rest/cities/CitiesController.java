package com.keyin.rest.cities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.keyin.rest.cities.Cities;
import com.keyin.rest.cities.CitiesService;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
public class CitiesController {
        @Autowired
    private CitiesService cityService;

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
        return cityService.createCity(newCity);
    }

    @PutMapping("/city/{id}")
    public Cities updateCity(@PathVariable long id, @RequestBody Cities updatedCity) {
        return cityService.updateCity(id, updatedCity);
    }
}