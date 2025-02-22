package com.keyin.rest.aircraft;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AircraftRepository extends CrudRepository<Aircraft, Long> {
    public Aircraft findByType(String type);
    public Aircraft findByAirlineName(String airlineName);
    public Aircraft findByNumberOfPassengers(int numberOfPassengers);
}