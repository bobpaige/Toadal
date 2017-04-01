package com.example.persistence;

import org.springframework.data.repository.CrudRepository;

import com.example.model.Game;

public interface GameRepository extends CrudRepository<Game, Long>{

}
