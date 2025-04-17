package com.keyin.rest.cities;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * CitiesRepository, is an interface to allow access to Cities related
 * data from the database.
 */
@Repository // Marks interface as a Spring Data repository
public interface CitiesRepository extends CrudRepository<Cities, Long> {
    // Custom query to find a city by name (i.e: St. John's)
    public Cities findByName(String name);

    // Custom query finding a city by its state (NL)
    public Cities findByState(String state);

    // Custom query to fetch a city by population density (5 billion)
    public Cities findByPopulation(int population);
}
