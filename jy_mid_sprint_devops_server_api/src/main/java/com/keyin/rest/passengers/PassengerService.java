package com.keyin.rest.passengers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PassengerService {
    @Autowired
    private PassengerRepository passengerRepository;

    public List<Passenger> findAllPassengers() {
        return (List<Passenger>) passengerRepository.findAll();
    }

    public Passenger findPassengerById(long id) {
        Optional<Passenger> optionalPassenger = passengerRepository.findById(id);

        return optionalPassenger.orElse(null);
    }

    public Passenger findByFirstName (String firstName) {
        return passengerRepository.findbyFirstName(firstName);
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