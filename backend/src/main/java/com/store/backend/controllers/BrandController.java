package com.store.backend.controllers;

import com.store.backend.entities.Brand;
import com.store.backend.services.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/brand")
@CrossOrigin
public class BrandController {

    @Autowired
    private BrandService service;

    @PostMapping("/")
    public Brand save(@RequestBody Brand obj) {
        return service.save(obj);
    }

    @GetMapping("/")
    public List<Brand> findAll() {
        return service.findAll();
    }

    @PutMapping("/")
    public Brand update(@RequestBody Brand obj) {
        return service.update(obj);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        service.delete(id);
        return  ResponseEntity.ok().build();
    }

}
