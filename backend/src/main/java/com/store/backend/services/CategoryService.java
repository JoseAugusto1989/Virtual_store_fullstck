package com.store.backend.services;


import com.store.backend.entities.Category;
import com.store.backend.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    public Category save(Category category) {
        category.setInitialDate(new Date());
        Category newCategory = categoryRepository.saveAndFlush(category);
        return newCategory;
    }

    public Category update(Category category) {
        category.setAtualizationDate(new Date());
        return categoryRepository.saveAndFlush(category);
    }

    public void delete(Long id) {
        Category category = categoryRepository.findById(id).get();
        categoryRepository.delete(category);
    }
}
