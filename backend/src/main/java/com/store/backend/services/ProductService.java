package com.store.backend.services;

import com.store.backend.entities.Person;
import com.store.backend.entities.Product;
import com.store.backend.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repo;

    public Product save(Product product) {
        product.setInitialDate(new Date());
        Product newPerson = repo.saveAndFlush(product);
        return newPerson;
    }

    public List<Product> findAll() {
        return repo.findAll();
    }

    public Product update(Product product) {
        product.setAtualizationDate(new Date());
        return repo.saveAndFlush(product);
    }

    public void delete(Long id) {
        Product product = repo.findById(id).get();
        repo.delete(product);
    }
}
