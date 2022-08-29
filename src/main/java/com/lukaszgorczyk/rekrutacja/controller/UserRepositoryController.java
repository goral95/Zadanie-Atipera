package com.lukaszgorczyk.rekrutacja.controller;

import com.lukaszgorczyk.rekrutacja.model.UserRepository;
import com.lukaszgorczyk.rekrutacja.service.UserRepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class UserRepositoryController {

    @Autowired
    private UserRepositoryService service;

    @GetMapping
    public List<UserRepository> getAllRepo(@RequestParam("user") String userName){
        return service.findAllRepo(userName);
    }
}
