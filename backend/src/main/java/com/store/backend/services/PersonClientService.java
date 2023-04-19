package com.store.backend.services;

import com.store.backend.dtos.PersonClientRequestDto;
import com.store.backend.entities.Person;
import com.store.backend.repositories.PermissionRepository;
import com.store.backend.repositories.PersonClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class PersonClientService {

    @Autowired
    private PersonClientRepository personRepository;

    @Autowired
    private PermissionPersonService permissionPersonService;

    @Autowired
    private EmailService emailService;

    public Person add(PersonClientRequestDto personClientRequestDto) {
        Person person = new PersonClientRequestDto().converter(personClientRequestDto);
        person.setInitialDate(new Date());
        Person newPerson = personRepository.saveAndFlush(person);
        permissionPersonService.addPersonPermissionClient(newPerson);
        emailService.sendEmailText(
                newPerson.getEmail(),
                "Cadastro de novo cliente no projeto do guto =D",
                "O registro na loja foi realizado com sucesso");
        return newPerson;
    }

}
