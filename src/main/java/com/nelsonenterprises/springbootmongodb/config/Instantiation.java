package com.nelsonenterprises.springbootmongodb.config;

import com.nelsonenterprises.springbootmongodb.domain.User;
import com.nelsonenterprises.springbootmongodb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {

        userRepository.deleteAll();

        User u1 = new User(null, "renato bonato", "renatinho@gmail.com");
        User u2 = new User(null, "felipe callegas", "calleguinhas@gmail.com");

        userRepository.saveAll(Arrays.asList(u1,u2));

    }
}

