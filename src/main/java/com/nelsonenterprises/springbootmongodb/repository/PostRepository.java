package com.nelsonenterprises.springbootmongodb.repository;

import com.nelsonenterprises.springbootmongodb.domain.Post;
import com.nelsonenterprises.springbootmongodb.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

    List<Post> findByTitleContainingIgnoreCase(String text);
}
