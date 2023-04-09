package com.store.backend.services;

import com.store.backend.entities.Person;
import com.store.backend.entities.State;
import com.store.backend.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PersonService {

    @Autowired
    private PersonRepository repository;

    public Person save(Person person) {
        person.setInitialDate(new Date());
        Person newPerson = repository.saveAndFlush(person);
        return newPerson;
    }

    public List<Person> findAll() {
        return repository.findAll();
    }

    public Person update(Person person) {
        person.setAtualizationDate(new Date());
        return repository.saveAndFlush(person);
    }

    public void delete(Long id) {
        Person person = repository.findById(id).get();
        repository.delete(person);
    }
}
