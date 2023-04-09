package com.store.backend.services;

import com.store.backend.entities.Permission;
import com.store.backend.repositories.PermissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PermissionService {

    @Autowired
    private PermissionRepository repository;

    public Permission save(Permission permission) {
        permission.setInitialDate(new Date());
        Permission newPermission = repository.saveAndFlush(permission);
        return newPermission;
    }

    public List<Permission> findAll() {
        return repository.findAll();
    }

    public Permission update(Permission permission) {
        permission.setAtualizationDate(new Date());
        return repository.saveAndFlush(permission);
    }

    public void delete(Long id) {
        Permission permission = repository.findById(id).get();
        repository.delete(permission);
    }
}
