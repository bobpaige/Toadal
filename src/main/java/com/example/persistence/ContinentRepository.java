package com.example.persistence;

import org.springframework.data.repository.CrudRepository;

import com.example.model.Continent;

public interface ContinentRepository extends CrudRepository<Continent, Long> {

}
