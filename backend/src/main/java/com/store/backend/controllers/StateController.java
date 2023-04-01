package com.store.backend.controllers;

import com.store.backend.entities.State;
import com.store.backend.services.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/state")
public class StateController {

    @Autowired
    private StateService service;

    @PostMapping("/")
    public State add(@RequestBody State state) {
        return service.save(state);
    }

    @PutMapping("/")
    public State update(@RequestBody State state) {
        return service.update(state);
    }

    @GetMapping("/")
    public List<State> getAll() {
        return service.findAll();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }

}
