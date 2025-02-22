package com.keyin.rest.passengers;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PassengerRepository extends CrudRepository<Passenger, Long> {
    public Passenger findbyFirstName(String firstName);
    public Passenger findbyLastName(String lastName);
    public Passenger findbyPhoneNumber(String phoneNumber);
}