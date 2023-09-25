package com.geekster.usermanagementsystemvalidations.controller;

import com.geekster.usermanagementsystemvalidations.entity.User;
import com.geekster.usermanagementsystemvalidations.service.Userservice;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Validated

public class Usercontroller {
    @Autowired
    Userservice userservice;
    //getallusers
    @GetMapping("users")
    List<User> getAllUsers()
    {
        return userservice.getAllUsers();
    }
    //addusers
    @PostMapping("users")
    public String addusers( @RequestBody @Valid List<User> newusers)
    {
        return userservice.addnewusers(newusers);
    }





}
