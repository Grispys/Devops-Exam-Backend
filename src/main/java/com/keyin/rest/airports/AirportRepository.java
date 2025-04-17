package com.keyin.rest.airports;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * AirportRepository, used as an interface to access Airport related
 * data from the database.
 */
@Repository // Marks interface as a Spring Data repository
public interface AirportRepository extends CrudRepository<Airport, Long> {
    // Custom query to find an airport by name
    public Airport findByName(String name);

    // Custom query used for finding an airport via its code
    public Airport findByCode(String code);
}