package com.ec.beerstore.repository;

import com.ec.beerstore.model.Beer;
import com.ec.beerstore.model.BeerType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BeerRepository extends JpaRepository<Beer, Long> {

    Beer findByNameAndType(String name, BeerType type);
}