package com.store.backend.dtos;


import com.store.backend.entities.City;
import com.store.backend.entities.Person;
import lombok.Data;
import org.springframework.beans.BeanUtils;

@Data
public class PersonClientRequestDto {

    private String name;

    private String cpf;

    private String email;

    private String address;

    private String cep;

    private City city;

    public Person converter(PersonClientRequestDto personClientRequestDto) {
        Person person = new Person();
        BeanUtils.copyProperties(personClientRequestDto, person);
        return person;
    }
}
