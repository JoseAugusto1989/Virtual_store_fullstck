package com.store.backend.controllers;

import com.store.backend.entities.Category;
import com.store.backend.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/category")
@CrossOrigin
public class CategoryController {

    @Autowired
    private CategoryService service;

    @GetMapping("/")
    public List<Category> findAll() {
        return service.findAll();
    }

    @PostMapping("/")
    public Category save(@RequestBody Category obj) {
        return service.save(obj);
    }

    @PutMapping("/")
    public Category update(@RequestBody Category obj) {
        return service.update(obj);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        service.delete((id));
        return ResponseEntity.ok().build();
    }

}
