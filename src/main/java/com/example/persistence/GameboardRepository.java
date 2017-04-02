package com.example.persistence;

import org.springframework.data.repository.CrudRepository;

import com.example.model.Gameboard;

public interface GameboardRepository extends CrudRepository<Gameboard, Long> {

}
