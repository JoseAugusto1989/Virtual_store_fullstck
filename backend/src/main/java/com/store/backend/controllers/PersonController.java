package com.store.backend.controllers;

import com.store.backend.entities.Person;
import com.store.backend.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/person")
@CrossOrigin
public class PersonController {

    @Autowired
    private PersonService service;

    @GetMapping("/")
    public List<Person> findAll() {
        return service.findAll();
    }

    @PostMapping("/")
    public Person save(@RequestBody Person obj) {
        return service.save(obj);
    }

    @PutMapping("/")
    public Person update(@RequestBody Person obj) {
        return service.update(obj);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }
}
