package com.nelsonenterprises.springbootmongodb.resources;

import com.nelsonenterprises.springbootmongodb.domain.User;
import com.nelsonenterprises.springbootmongodb.dto.UserDTO;
import com.nelsonenterprises.springbootmongodb.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.lang.reflect.Array;
import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value="/users")
public class UserResource {

    @Autowired
    private UserService service;

    @RequestMapping(method= RequestMethod.GET)
    public ResponseEntity<List<UserDTO>> findAll(){
        List<User> list = service.findAll();
        List<UserDTO> listDto = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }

    @RequestMapping(value="/{id}", method= RequestMethod.GET)
    public ResponseEntity<UserDTO> findbyId(@PathVariable String id){
        User obj = service.findById(id);
        return ResponseEntity.ok().body(new UserDTO(obj));
    }
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> insertUser(@RequestBody UserDTO userDTO) {
        User obj = service.fromDTO(userDTO);
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
}
