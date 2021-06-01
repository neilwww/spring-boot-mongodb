package com.nelsonenterprises.springbootmongodb.services;

import com.nelsonenterprises.springbootmongodb.domain.User;
import com.nelsonenterprises.springbootmongodb.dto.UserDTO;
import com.nelsonenterprises.springbootmongodb.repository.UserRepository;
import com.nelsonenterprises.springbootmongodb.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public List<User> findAll(){
        return repo.findAll();
    }

    public User findById(String id){
        User userById = repo.findById(id).orElse(null);
        if (userById == null) {
            throw new ObjectNotFoundException("Object not found ");
        }
        return userById;
    }

    public User insert(User obj){
        return repo.insert(obj);
    }
    public User fromDTO(UserDTO objDTO){
        return new User(objDTO.getId(), objDTO.getName(), objDTO.getEmail());
    }
    public void delete(String id){
        findById(id);
        repo.deleteById(id);
    }
    public User update (User obj){
        User upObj = repo.findById(obj.getId()).orElse(null);
        updateData(upObj, obj);
        return repo.save(upObj);
    }
    private void updateData(User upObj, User obj) {
        upObj.setName(obj.getName());
        upObj.setEmail(obj.getEmail());
    }

}
