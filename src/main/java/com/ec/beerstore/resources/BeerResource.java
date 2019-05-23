package com.ec.beerstore.resources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/beers")
public class BeerResource {

    @GetMapping
    public List<String> findAll() {
        return Arrays.asList("Heineken", "Colorado Indigo", "Stella Artois", "Bohemia");
    }
}