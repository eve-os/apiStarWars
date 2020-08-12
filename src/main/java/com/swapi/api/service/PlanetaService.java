package com.swapi.api.service;

import com.swapi.api.domain.Planeta;
import com.swapi.api.dto.PlanetaDTO;
import com.swapi.api.repository.PlanetaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import static javax.servlet.http.HttpServletResponse.SC_OK;

@Service
    public class PlanetaService {

    @Value("${url.swapi}")
    private String swapiUrl;

    @Autowired
    private PlanetaRepository planetaRepository;
    @Autowired
    RestTemplate restTemplate;

    public PlanetaService() {
    }

    public List<Planeta> findAll() {
        return planetaRepository.findAll();
    }

    public Optional<Planeta> findByID(String id) {
        return planetaRepository.findById(id);
    }

    public List<Planeta> findByName(String name) {
        return planetaRepository.findByName();
    }

    public Integer filmAppearances(String name) throws Exception {
        final String baseUrl = swapiUrl + "?search=" + name;
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");
        HttpEntity<PlanetaDTO> requestEntity = new HttpEntity<>(null, headers);
        URI uri = new URI(baseUrl);

        ResponseEntity<PlanetaDTO> response = restTemplate.exchange(uri, HttpMethod.GET, requestEntity, PlanetaDTO.class);

        if ((response.getStatusCodeValue() == SC_OK) && (response.getBody().getResults().size() > 0)) {
            return countFilms(response.getBody());
        } else {
            return 0;
        }
    }

    private Integer countFilms(PlanetaDTO response) {
        return response.getResults().get(0).getFilms().size();
    }

    public Planeta create(Planeta planeta) throws Exception {
        planeta.setNumberOfFilms(filmAppearances(planeta.getName()));
        return planetaRepository.save(planeta);
    }

    public void deleteById(String id) {
        planetaRepository.deleteById(id);
    }

    public Planeta update(Planeta planeta) {
        Optional<Planeta> antigo = planetaRepository.findById(planeta.getId());
        antigo = Optional.of(planeta);
        return planetaRepository.save(antigo.get());
    }

}