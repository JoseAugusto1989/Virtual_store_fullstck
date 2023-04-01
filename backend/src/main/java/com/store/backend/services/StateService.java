package com.store.backend.services;

import com.store.backend.entities.State;
import com.store.backend.repositories.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class StateService {

    @Autowired
    private StateRepository repository;

    public State save(State state) {
        state.setInitialDate(new Date());
        State newState = repository.saveAndFlush(state);
        return newState;
    }

    public List<State> findAll() {
        return repository.findAll();
    }

    public State update(State state) {
        state.setAtualizationDate(new Date());
        return repository.saveAndFlush(state);
    }

    public void delete(Long id) {
        State state = repository.findById(id).get();
        repository.delete(state);
    }
}
