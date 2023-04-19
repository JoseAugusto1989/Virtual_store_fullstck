package com.store.backend.services;

import com.store.backend.entities.Permission;
import com.store.backend.entities.Person;
import com.store.backend.entities.PersonPermission;
import com.store.backend.repositories.PermissionPersonRepository;
import com.store.backend.repositories.PermissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PermissionPersonService {

    @Autowired
    private PermissionPersonRepository permissionPersonRepository;

    @Autowired
    private PermissionRepository permissionRepository;

    public void addPersonPermissionClient(Person person) {
        List<Permission> permissionList = permissionRepository.findByName("cliente");
        if (permissionList.size() > 0) {
            PersonPermission personPermission = new PersonPermission();
            personPermission.setPerson(person);
            personPermission.setPermission(permissionList.get(0));
            personPermission.setInitialDate(new Date());
            permissionPersonRepository.saveAndFlush(personPermission);
        }
    }
}
