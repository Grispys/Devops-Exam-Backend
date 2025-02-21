package com.keyin.rest.cities;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CitiesRepository extends CrudRepository<Cities, Long> {
    public Cities findByName(String name);
    public Cities findByState(String state);
    public Cities findByPopulation(int population);
}
