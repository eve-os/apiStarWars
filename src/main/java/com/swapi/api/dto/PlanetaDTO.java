package com.swapi.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class PlanetaDTO {

    @JsonProperty("films")
    private List<String> films;

    @JsonProperty("name")
    private String name;

    @JsonProperty("results")
    private List<PlanetaDTO> results;

    @JsonProperty("count")
    private int count;


    public List<String> getFilms() {
        return films;
    }

    public void setFilms(List<String> films) {
        this.films = films;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<PlanetaDTO> getResults() {
        return results;
    }

    public void setResults(List<PlanetaDTO> results) {
        this.results = results;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}


