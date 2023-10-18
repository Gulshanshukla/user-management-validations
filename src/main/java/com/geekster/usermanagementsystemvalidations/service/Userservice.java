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


    public void deleteUserById(Integer userId) {
        List<User> users = userrepo.getUserList();
        users.removeIf(user -> user.getUserId().equals(userId));
    }

    public User updateUserById(Integer userId, User updatedUser) {
        List<User> users = userrepo.getUserList();
        for (User user : users) {
            if (user.getUserId().equals(userId)) {
                user.setUserName(updatedUser.getUserName());
                user.setUserEmail(updatedUser.getUserEmail());
                user.setUserDOB(updatedUser.getUserDOB());
                user.setUserContactNo(updatedUser.getUserContactNo());
                // Add more update logic as needed
                return user;
            }
        }
        return null;
    }
}
