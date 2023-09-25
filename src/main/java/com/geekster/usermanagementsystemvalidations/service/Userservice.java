package com.geekster.usermanagementsystemvalidations.service;
import com.geekster.usermanagementsystemvalidations.entity.User;
import com.geekster.usermanagementsystemvalidations.repo.UserRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class Userservice {
    @Autowired
    UserRepo userrepo;

    public String addnewusers(List<User> newusers) {
        getAllUsers().addAll(newusers);
        return newusers.size() + "user were added";
    }

    public List<User> getAllUsers() {
        return userrepo.getUserList();
    }


}
