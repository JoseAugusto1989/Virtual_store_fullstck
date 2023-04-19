package com.store.backend.repositories;

import com.store.backend.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonClientRepository extends JpaRepository<Person, Long> {

}
