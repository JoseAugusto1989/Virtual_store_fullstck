package com.store.backend.services;

import com.store.backend.dtos.PersonClientRequestDto;
import com.store.backend.entities.Person;
import com.store.backend.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class ManagerPersonService {

    @Autowired
    private PersonRepository personRepo;


    @Autowired
    private EmailService emailService;

    public String checkCode(String email) {
        Person person = personRepo.findByEmail(email);
        person.setRecuperationCodePassword(getRecuperationCodePassword(person.getId()));
        person.setSendDateCode(new Date());
        personRepo.saveAndFlush(person);

        emailService.sendEmailText(person.getEmail(),
                "Código de recuperação de senha",
                "Olá, o seu código para recuperação de senha é o seguinte: "
                        + person.getRecuperationCodePassword());
        return "Código enviado com sucesso";
    }

    public String updatePassword(Person person) {
        Person personBank = personRepo.findByEmailAndCodeRecoverPassword(
                person.getEmail(), person.getRecuperationCodePassword());

        if (personBank != null) {
            Date diference = new Date(new Date().getTime() - personBank.getSendDateCode().getTime());

            // TODO: expira em 15 minutos
            if (diference.getTime()/ 1000 < 900) {
                personBank.setPassword(person.getPassword());
                personBank.setRecuperationCodePassword(null);
                personRepo.saveAndFlush(personBank);
                return "Senha alterada com sucesso!";
            } else {
                return "Tempo expirado, solicite um novo código";
            }
        } else {
            return "Email ou código não encontardo!";
        }
    }

    private String getRecuperationCodePassword(Long id) {
        DateFormat format = new SimpleDateFormat("ddMMyyyyHHmmssmm");
        return format.format(new Date()) + id;
    }


}
