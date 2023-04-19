package com.store.backend.controllers;

import com.store.backend.dtos.PersonClientRequestDto;
import com.store.backend.entities.Person;
import com.store.backend.services.PersonClientService;
import com.store.backend.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/client")
public class PersonClientController {

    @Autowired
    private PersonClientService personService;

    @PostMapping("/")
    public Person add(@RequestBody PersonClientRequestDto personClientRequestDto)  {
        return personService.add(personClientRequestDto);
    }
}
