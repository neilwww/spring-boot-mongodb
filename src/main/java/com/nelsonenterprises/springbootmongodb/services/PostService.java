package com.nelsonenterprises.springbootmongodb.services;

import com.nelsonenterprises.springbootmongodb.domain.Post;
import com.nelsonenterprises.springbootmongodb.repository.PostRepository;
import com.nelsonenterprises.springbootmongodb.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {

    @Autowired
    private PostRepository repo;

    public Post findById(String id){
        Post postById = repo.findById(id).orElse(null);
        if (postById == null){
            throw new ObjectNotFoundException("Object not found");
        }
        return postById;
    }

}
