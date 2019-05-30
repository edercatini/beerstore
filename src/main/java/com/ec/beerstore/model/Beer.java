package com.ec.beerstore.model;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
public class Beer implements Serializable {

    private static final long serialVersionUID = 5089614055720676114L;

    @Id
    @SequenceGenerator(name = "beer_seq", sequenceName = "beer_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "beer_seq")
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private BeerType type;

    private BigDecimal volume;

    public Long getId() {
        return id;
    }

    public Beer setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Beer setName(String name) {
        this.name = name;
        return this;
    }

    public BeerType getType() {
        return type;
    }

    public Beer setType(BeerType type) {
        this.type = type;
        return this;
    }

    public BigDecimal getVolume() {
        return volume;
    }

    public Beer setVolume(BigDecimal volume) {
        this.volume = volume;
        return this;
    }
}