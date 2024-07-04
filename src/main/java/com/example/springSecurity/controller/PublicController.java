package com.example.springSecurity.controller;

import com.example.springSecurity.entity.User;
import com.example.springSecurity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/public")
public class PublicController {

    @Autowired
    public UserService userService;

    @PostMapping("/add-user")
    public void addUser(@RequestBody User user){
        userService.addUser(user);
    }

}
