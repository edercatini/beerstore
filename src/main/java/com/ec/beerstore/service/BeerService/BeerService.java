package com.ec.beerstore.service.BeerService;

import com.ec.beerstore.model.Beer;
import com.ec.beerstore.repository.BeerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BeerService {

    private BeerRepository repository;

    @Autowired
    public BeerService(BeerRepository repository) {
        this.repository = repository;
    }

    public List<Beer> findAll() {
        return repository.findAll();
    }

    public Beer findById(Long id) {
        Optional<Beer> beer = repository.findById(id);
        return beer.orElseThrow(() -> new IllegalArgumentException("Invalid ID"));
    }

    public Beer save(Beer beer) {
        return repository.save(beer);
    }

    public void update(Beer beer, Long id) {
        Beer object = this.findById(id);
        repository.save(object.setName(beer.getName()).setType(beer.getType()).setVolume(beer.getVolume()));
    }

    public void deleteById(Long id) {
        repository.delete(this.findById(id));
    }

    public void deleteAll() {
        repository.deleteAll();
    }
}