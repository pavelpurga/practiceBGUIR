package com.example.springweb.controllers;


import com.example.springweb.entity.Product;
import com.example.springweb.entity.Users;
import com.example.springweb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "http://localhost:3000")
public class UsersController {
    private final UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public  ResponseEntity<List<Users>> getProducts(){
        List<Users> users = userService.findAll();
        return ResponseEntity.ok(users);
    }
    @GetMapping("/{name}")
    public ResponseEntity<List<Users>> showUser(@PathVariable String name){
        List<Users> users = userService.findUsersByName(name);
        return ResponseEntity.ok(users);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Integer id){
        userService.deleteUserById(id);
        return ResponseEntity.ok().build();
    }
    @PostMapping
    public  ResponseEntity<Users> addUser(@RequestBody Users users){
        Users users1 = userService.addUser(users);
        return ResponseEntity.ok(users1);
    }
    @PutMapping("/{id}")
    public  ResponseEntity<Users> updateUsers(@PathVariable Integer id,@RequestBody Users users){
        Optional<Users> idForSearch = userService.getUserById(id);
        if(idForSearch.isPresent()){
            Users users1 = idForSearch.get();
            users1.setName(users.getName());
            users1.setAge(users.getAge());
            users1.setEmail(users.getEmail());
            users1.setPassword(users.getPassword());
            users1.setRoles(users.getRoles());
            users1.setBasket_id(users.getBasket_id());
            userService.updateUser(users1);
            return ResponseEntity.ok(users1);
        }else return ResponseEntity.notFound().build();
    }
}
