package com.store.backend.services;

import com.store.backend.entities.City;
import com.store.backend.repositories.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CityService {

    @Autowired
    private CityRepository repository;

    public List<City> findAll() {
        return repository.findAll();
    }

    public City add(City city) {
        city.setInitialDate(new Date());
        City newCity = repository.saveAndFlush(city);
        return newCity;
    }

    public City update(City city) {
        city.setAtualizationDate(new Date());
        return repository.saveAndFlush(city);
    }

    public void delete(Long id) {
        City city = repository.findById(id).get();
        repository.delete(city);
    }
}
