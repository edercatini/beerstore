package com.ec.beerstore.repository;

import com.ec.beerstore.model.Beer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BeerRepository extends JpaRepository<Beer, Long> {
}