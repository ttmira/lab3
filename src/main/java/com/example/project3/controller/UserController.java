package com.example.project3.controller;

import com.example.project3.model.User;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ConcurrentHashMap;

@RestController
@RequestMapping("/api")
public class UserController {
    private ConcurrentHashMap<Long, User> users=new ConcurrentHashMap<>();
    public UserController(){
        users.put(1L,new User(1L,"Tamara",19));
        users.put(2L,new User(2L,"Asel",20));
    }

    @PutMapping("/user/{id}")
    public ResponseEntity<?> updateUser(@PathVariable Long id, @RequestBody User userData){
        User existingUser=users.get(id);
        if(existingUser != null){
            existingUser.setName(userData.getName());
            existingUser.setAge(userData.getAge());
            users.put(id,existingUser);
            return ResponseEntity.ok(existingUser);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User"+id+"not found");
        }
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<?>deleteUser(@PathVariable Long id){
        User removedUser=users.remove(id);
        if(removedUser != null){
            return ResponseEntity.ok("User in Id"+id+"sucsses removed");
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User in id"+id+"not found");
        }
    }
}
