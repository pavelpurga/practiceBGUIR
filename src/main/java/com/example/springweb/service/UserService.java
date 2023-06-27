package com.example.springweb.service;

import com.example.springweb.entity.Users;
import com.example.springweb.repository.UsersRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private UsersRepository usersRepository;

    @Autowired
    public UserService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public List<Users> findUsersByName(String name) {
        return usersRepository.findByName(name);
    }

    @Transactional
    public List<Users> deleteUserByName(String name){
        return usersRepository.deleteByName(name);
    }

    public Users addUser(Users users){
        return usersRepository.save(users);
    }

    public  Users updateUser(Users users){
        return usersRepository.save(users);
    }

    public Optional<Users> getUserById(Integer productId){
        return usersRepository.getUsersById(productId);
    }

}
