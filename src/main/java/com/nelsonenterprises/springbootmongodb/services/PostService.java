package com.nelsonenterprises.springbootmongodb.services;

import com.nelsonenterprises.springbootmongodb.domain.Post;
import com.nelsonenterprises.springbootmongodb.repository.PostRepository;
import com.nelsonenterprises.springbootmongodb.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

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

    public List<Post> findByTitle(String text){
        return repo.searchTitle(text);
    }


    public List<Post> fullSearch(String text, Date minDate, Date maxDate) {
        maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000);
        return repo.fullSearch(text, minDate, maxDate);
    }
}
