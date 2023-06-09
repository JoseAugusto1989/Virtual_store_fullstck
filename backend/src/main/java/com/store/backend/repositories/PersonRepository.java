package com.store.backend.repositories;

import com.store.backend.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
    Person findByEmail(String email);
    Person findByEmailAndCodeRecoverPassword(String email, String recoverCodePassword);
}
