package com.geekster.usermanagementsystemvalidations.repo;


import com.geekster.usermanagementsystemvalidations.entity.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;
@Configuration

public class UserFactory {
    @Bean
    List<User> getUserListInit()
    {
        return new ArrayList<>();

    }
}
