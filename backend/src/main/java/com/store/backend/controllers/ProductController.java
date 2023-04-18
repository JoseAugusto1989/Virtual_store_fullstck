package com.store.backend.controllers;

import com.store.backend.entities.Product;
import com.store.backend.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
@CrossOrigin
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping("/")
    public List<Product> findAll() {
        return service.findAll();
    }

    @PostMapping("/")
    public Product save(@RequestBody Product obj) {
        return service.save(obj);
    }

    @PutMapping("/")
    public Product update(@RequestBody Product obj) {
        return service.update(obj);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }
}
