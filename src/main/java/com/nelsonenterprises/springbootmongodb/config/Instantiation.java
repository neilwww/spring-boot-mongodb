package com.nelsonenterprises.springbootmongodb.config;

import com.nelsonenterprises.springbootmongodb.domain.Post;
import com.nelsonenterprises.springbootmongodb.domain.User;
import com.nelsonenterprises.springbootmongodb.dto.AuthorDTO;
import com.nelsonenterprises.springbootmongodb.repository.PostRepository;
import com.nelsonenterprises.springbootmongodb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;
import java.util.TimeZone;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {


        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        userRepository.deleteAll();
        postRepository.deleteAll();

        User renato = new User(null, "renato bonato", "renatinho@gmail.com");
        User felipe = new User(null, "felipe callegas", "calleguinhas@gmail.com");

        userRepository.saveAll(Arrays.asList(renato,felipe));

        Post post1 = new Post(null, sdf.parse("23/09/2020"), "na academia", "malhando perna", new AuthorDTO(felipe));

        postRepository.saveAll(Arrays.asList(post1));

        felipe.getPosts().addAll(Arrays.asList(post1));
        userRepository.save(felipe);
    }
}

