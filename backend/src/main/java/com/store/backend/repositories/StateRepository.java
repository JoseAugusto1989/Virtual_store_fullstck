package com.store.backend.repositories;

import com.store.backend.entities.State;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StateRepository extends JpaRepository<State, Long> {
    
}
