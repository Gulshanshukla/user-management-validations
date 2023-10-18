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
    @DeleteMapping("user/id{id}")
    public void deleteUser(@RequestParam Integer userId) {
        userservice.deleteUserById(userId);
    }
    @PutMapping("update/user/id/{id}")
    public User updateUser(@RequestParam Integer userId, @RequestBody User updatedUser) {
        User user = userservice.updateUserById(userId, updatedUser);
        if (user == null) {
            // You can throw an exception or handle the "user not found" case here
        }
        return user;
    }






}
