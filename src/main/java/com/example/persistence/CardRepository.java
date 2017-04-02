package com.example.persistence;

import org.springframework.data.repository.CrudRepository;

import com.example.model.Card;

public interface CardRepository extends CrudRepository<Card, Long>{

}
