package com.store.backend.controllers;

import com.store.backend.dtos.PersonClientRequestDto;
import com.store.backend.entities.Person;
import com.store.backend.services.ManagerPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/personManager")
public class ManagerPersonController {

    @Autowired
    private ManagerPersonService managerPersonService;

    @PostMapping("/recoverCode")
    public String recoverCode(@RequestBody Person person) {
        return managerPersonService.checkCode(person.getEmail());
    }

    @PostMapping("/updatePassword")
    public String updatePassword(@RequestBody Person person) {
        return managerPersonService.updatePassword(person);
    }
}
