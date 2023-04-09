package com.store.backend.controllers;

import com.store.backend.entities.City;
import com.store.backend.services.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/city")
public class CityController {

    @Autowired
    private CityService service;

    @GetMapping("/")
    public List<City> findAll() {
        return service.findAll();
    }

    @PostMapping("/")
    public City add(@RequestBody City city) {
        return service.add(city);
    }

    @PutMapping
    public City update(@RequestBody City city) {
        return service.update(city);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }
}
