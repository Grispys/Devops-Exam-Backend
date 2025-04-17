package com.keyin.rest.passengers;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * PassengerRepository, is an interface to allow access to Passenger related
 * data from the database.
 */
@Repository // Marks interface as a Spring Data repository
public interface PassengerRepository extends CrudRepository<Passenger, Long> {
    // Custom query fetching a passengers first name
    public Passenger findByFirstName(String firstName);

    // Custom query to nab their last name instead
    public Passenger findByLastName(String lastName);

    // Custom query for a passengers phone number
    public Passenger findByPhoneNumber(String phoneNumber);
}