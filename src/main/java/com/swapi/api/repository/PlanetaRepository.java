package com.swapi.api.repository;

import com.swapi.api.domain.Planeta;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface PlanetaRepository extends MongoRepository<Planeta, String> {
    Optional<Planeta> findById(String id);

    List<Planeta> findByName();
}
