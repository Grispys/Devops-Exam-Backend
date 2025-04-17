package com.keyin.rest.aircraft;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * AircraftRepository class acts as an interface for accessing Aircraft
 * data from the database.
 */
@Repository // Marks interface as a Spring Data repository
public interface AircraftRepository extends CrudRepository<Aircraft, Long> {
    // Custom query to find aircraft by its type
    public Aircraft findByType(String type);

    // Custom query to find an aircraft through its airline name
    public Aircraft findByAirlineName(String airlineName);

    // Custom query to find an aircraft from its number of passengers aboard
    public Aircraft findByNumberOfPassengers(int numberOfPassengers);
}