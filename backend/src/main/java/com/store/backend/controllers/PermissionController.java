package com.store.backend.controllers;

import com.store.backend.entities.Permission;
import com.store.backend.services.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/permission")
@CrossOrigin
public class PermissionController {

    @Autowired
    private PermissionService service;

    @GetMapping("/")
    public List<Permission> findAll() {
        return service.findAll();
    }

    @PostMapping("/")
    public Permission save(@RequestBody Permission obj) {
        return service.save(obj);
    }

    @PutMapping("/")
    public Permission update(@RequestBody Permission obj) {
        return service.update(obj);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }
}
