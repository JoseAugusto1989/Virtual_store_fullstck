package com.store.backend.services;

import com.store.backend.entities.Brand;
import com.store.backend.repositories.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class BrandService {

    @Autowired
    private BrandRepository brandRepository;

    public Brand save(Brand brand) {
        brand.setInitialDate(new Date());
        Brand newBrand = brandRepository.saveAndFlush(brand);
        return newBrand;
    }

    public List<Brand> findAll() {
        return brandRepository.findAll();
    }

    public Brand update(Brand brand) {
        brand.setAtualizationDate(new Date());
        return brandRepository.saveAndFlush(brand);
    }

    public void delete(Long id) {
        Brand brand = brandRepository.findById(id).get();
        brandRepository.delete(brand);
    }
}
