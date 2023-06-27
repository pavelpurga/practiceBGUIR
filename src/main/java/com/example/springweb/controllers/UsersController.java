package com.example.springweb.controllers;


import com.example.springweb.entity.Users;
import com.example.springweb.service.UserService;
import org.apache.catalina.User;
import org.apache.naming.factory.ResourceLinkFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class UsersController {
    private final UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/userFind")
    public ResponseEntity<List<Users>> showUser(@RequestParam String name){
        List<Users> users = userService.findUsersByName(name);
        return ResponseEntity.ok(users);
    }
    @DeleteMapping("/userDel")
    public ResponseEntity<List<Users>> deleteUser(@RequestParam String name){
        List<Users> users = userService.deleteUserByName(name);
        return ResponseEntity.ok(users);
    }
    @PostMapping("/userAdd")
    public  ResponseEntity<Users> addUser(@RequestBody Users users){
        Users users1 = userService.addUser(users);
        return ResponseEntity.ok(users1);
    }
    @PutMapping("/userUpdate")
    public  ResponseEntity<Users> updateUsers(@RequestParam Integer usersId,@RequestBody Users users){
        Optional<Users> idForSearch = userService.getUserById(usersId);
        if(idForSearch.isPresent()){
            Users users1 = idForSearch.get();
            users1.setName(users.getName());
            users1.setAge(users.getAge());
            users1.setEmail(users.getEmail());
            users1.setPassword(users.getPassword());
            users1.setRole(users.getRole());
            users1.setBasket_id(users.getBasket_id());
            userService.updateUser(users1);
            return ResponseEntity.ok(users1);
        }else return ResponseEntity.notFound().build();
    }
}
