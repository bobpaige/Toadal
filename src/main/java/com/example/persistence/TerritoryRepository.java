package com.example.persistence;

import org.springframework.data.repository.CrudRepository;

import com.example.model.Territory;

public interface TerritoryRepository extends CrudRepository<Territory, Long> {

}
