package com.keyin.rest.cities;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * CitiesService, a class meant to tackle all Cities data and business logic.
 * Provides methods for retrieving, creating, updating, and searching for
 * city records.
 */
@Service // Marks class as a Spring service, used for dependency injection
public class CitiesService {
    @Autowired
    private CitiesRepository cityRepository; // Inject CitiesRepository for DB interaction

    // Retrieve all records on cities found in the DB
    public List<Cities> findAllCities() {
        return (List<Cities>) cityRepository.findAll();
    }

    // Retrieve city by its ID, will return null if none is found
    public Cities findCityById(long id) {
        Optional<Cities> optionalCity = cityRepository.findById(id);

        return optionalCity.orElse(null);
    }

    // Find a city by name
    public Cities findByName(String name) {
        return cityRepository.findByName(name);
    }

    // Create & save new city information to DB
    public Cities createCity(Cities newCity) {
        return cityRepository.save(newCity);
    }

    // Update city credentials and record it in DB, return null if city not found
    public Cities updateCity(long id, Cities updatedCity) {
        Cities cityToUpdate = findCityById(id);

        if (cityToUpdate != null) {
            cityToUpdate.setName(updatedCity.getName());
            cityToUpdate.setState(updatedCity.getState());
            cityToUpdate.setPopulation(updatedCity.getPopulation());

            return cityRepository.save(cityToUpdate);
        }

        return null;
    }
}
