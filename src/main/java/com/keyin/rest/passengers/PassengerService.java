package com.keyin.rest.passengers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * PassengerService classes purpose is to handle business logic related to passengers.
 * Provides methods to find, create, and update passenger data.
 */
@Service // Marks class as a Spring service, used for dependency injection
public class PassengerService {
    @Autowired
    private PassengerRepository passengerRepository; // Inject PassengerRepository for DB interaction

    public List<Passenger> findAllPassengers() {
        return (List<Passenger>) passengerRepository.findAll();
    }

    public Passenger findPassengerById(long id) {
        Optional<Passenger> optionalPassenger = passengerRepository.findById(id);

        return optionalPassenger.orElse(null);
    }

    public Passenger findByFirstName (String firstName) {
        return passengerRepository.findByFirstName(firstName);
    }

    public Passenger createPassenger(Passenger newPassenger) {
        return passengerRepository.save(newPassenger);
    }

    public Passenger updatePassenger(long id, Passenger updatedPassenger) {
        Passenger passengerToUpdate = findPassengerById(id);

        if (passengerToUpdate != null) {
            passengerToUpdate.setId(id);
            passengerToUpdate.setFirstName(updatedPassenger.getFirstName());
            passengerToUpdate.setLastName(updatedPassenger.getLastName());
            passengerToUpdate.setPhoneNumber(updatedPassenger.getPhoneNumber());

            return passengerRepository.save(passengerToUpdate);
        }

        return null;
    }
}