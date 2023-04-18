package com.store.backend.controllers;

import com.store.backend.entities.Images;
import com.store.backend.services.ImagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/images")
@CrossOrigin
public class ImagesController {

    @Autowired
    private ImagesService service;

    @GetMapping("/")
    public List<Images> findAll() {
        return service.findAll();
    }

    @PostMapping("/")
    public Images add(@RequestParam("ID_PRODUTO") Long idProduct, @RequestParam("file")MultipartFile file) {
        return service.add(idProduct, file);
    }

    @PutMapping("/")
    public Images update(@RequestBody Images obj) {
        return service.update(obj);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }

}
