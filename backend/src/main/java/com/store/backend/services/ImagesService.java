package com.store.backend.services;

import com.store.backend.entities.Images;
import com.store.backend.entities.Product;
import com.store.backend.repositories.ImagesRepository;
import com.store.backend.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;

@Service
public class ImagesService {

    @Autowired
    private ImagesRepository repo;

    @Autowired
    private ProductRepository repoProduct;

    public List<Images> findAll() {
        return repo.findAll();
    }

    public Images add(Long id, MultipartFile file) {
        Product product = repoProduct.findById(id).get();
        Images obj = new Images();

        // salvando informações da imagem em uma pasta no meu pc
        try {
            if (!file.isEmpty()) {
                byte[] bytes = file.getBytes();
                String imageName = String.valueOf(product.getId()) + file.getOriginalFilename();
                Path path = Paths.get("~/Imagens/imagensSpring/" + imageName);
                Files.write(path, bytes);

                obj.setName(imageName);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        obj.setProduct(product);
        obj.setInitialDate(new Date());
        obj = repo.saveAndFlush(obj);
        return obj;
    }

    public Images update(Images obj) {
        obj.setAtualizationDate(new Date());
        return repo.saveAndFlush(obj);
    }

    public void delete(Long id) {
        Images obj = repo.findById(id).get();
        repo.delete(obj);
    }
}
