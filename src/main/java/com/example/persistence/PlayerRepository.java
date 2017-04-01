package com.example.persistence;

import org.springframework.data.repository.CrudRepository;

import com.example.model.Player;

public interface PlayerRepository extends CrudRepository<Player, Long>{

}
