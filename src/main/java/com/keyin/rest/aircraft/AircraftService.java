package com.keyin.rest.aircraft;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * AircraftService class provides Aircraft-related data and business logic,
 * allowing for methods to retrieve, create, update, and search for aircraft
 * records.
 */
@Service // Marks class as a Spring service, used for dependency injection
public class AircraftService {
    @Autowired
    private AircraftRepository aircraftRepository; // Inject AircraftRepository for DB interaction

    // Retrieves all aircraft records from the DB
    public List<Aircraft> findAllAircrafts() {
        return (List<Aircraft>) aircraftRepository.findAll();
    }

    // Retrieves an aircraft by its ID, will return as null if not found
    public Aircraft findAircraftById(long id) {
        Optional<Aircraft> optionalAircraft = aircraftRepository.findById(id);

        return optionalAircraft.orElse(null);
    }

    // Searches for aircraft by type (i.e: MiG-25 Foxbat)
    public Aircraft findByType(String type) {
        return aircraftRepository.findByType(type);
    }

    // Create & save new aircraft record to the DB
    public Aircraft createAircraft(Aircraft newAircraft) {
        return aircraftRepository.save(newAircraft);
    }

    // Update existing aircraft record, return as null if no data is found
    public Aircraft updateAircraft(long id, Aircraft updatedAircraft) {
        Aircraft aircraftToUpdate = findAircraftById(id);

        if (aircraftToUpdate != null) {
            aircraftToUpdate.setType(updatedAircraft.getType());
            aircraftToUpdate.setAirlineName(updatedAircraft.getAirlineName());
            aircraftToUpdate.setNumberOfPassengers(updatedAircraft.getNumberOfPassengers());

            return aircraftRepository.save(aircraftToUpdate);
        }

        return null;
    }
}