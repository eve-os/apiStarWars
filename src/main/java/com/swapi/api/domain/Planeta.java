package com.swapi.api.domain;

import lombok.NonNull;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

@Document(collection = "Planeta")

public class Planeta {

    public Planeta(String name, String climate, String terrain) {
        this.name = name;
        this.climate = climate;
        this.terrain = terrain;
        this.numberOfFilms = numberOfFilms;
    }

    @Id
    private String id;
    @NonNull
    private String name;
    private String climate;
    private String terrain;
    private Integer numberOfFilms;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClimate() {
        return climate;
    }

    public void setClimate(String climate) {
        this.climate = climate;
    }

    public String getTerrain() {
        return terrain;
    }

    public void setTerrain(String terrain) {
        this.terrain = terrain;
    }

    public Integer getNumberOfFilms() {
        return numberOfFilms;
    }

    public void setNumberOfFilms(Integer numberOfFilms) {
        this.numberOfFilms = numberOfFilms;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


}