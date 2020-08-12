package com.swapi.api.controller;

import com.swapi.api.domain.Planeta;
import com.swapi.api.service.PlanetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/planeta")
public class PlanetaController {

    @Autowired
    private PlanetaService planetaService;

    @GetMapping
    List<Planeta> findAll(){
        return planetaService.findAll();
    }

    @GetMapping("/{id}")
    ResponseEntity<Planeta> findById(@PathVariable String id) {
        Optional<Planeta> planeta = planetaService.findByID(id);
        if (planeta.isPresent()){
            return ResponseEntity.ok(planetaService.findByID(id).get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{find/name}")
    ResponseEntity<List<Planeta>> findByName(@PathVariable String name){
        List<Planeta> planeta = planetaService.findByName(name);
            return ResponseEntity.ok(planetaService.findByName(name));
        }

    @PostMapping()
    ResponseEntity<Planeta> create (@RequestBody Planeta planeta, UriComponentsBuilder uriBuilder) throws Exception {
        Planeta novoPlaneta = planetaService.create(planeta);
        URI uri = uriBuilder.path("/planeta/{id}").buildAndExpand(novoPlaneta.getId()).toUri();
        return ResponseEntity.created(uri).body(novoPlaneta);
    }

    @PutMapping()
    ResponseEntity<Planeta> update(@RequestBody Planeta planeta) {
        return ResponseEntity.ok(planetaService.update(planeta));
    }

    @DeleteMapping("{id}")
    ResponseEntity deleteById(@PathVariable String id){
        Optional<Planeta> planeta = planetaService.findByID(id);
        if (planeta.isPresent()) {
            planetaService.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
