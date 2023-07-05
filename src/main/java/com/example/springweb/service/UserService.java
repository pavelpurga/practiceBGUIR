package com.example.springweb.service;

import com.example.springweb.entity.Product;
import com.example.springweb.entity.Users;
import com.example.springweb.repository.UsersRepository;
import io.micrometer.common.lang.NonNull;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UsersRepository usersRepository;

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
    public Optional<Users> getByLogin(@NonNull String name) {
        return usersRepository.findByName(name).stream().findFirst();
    }

    @Transactional
    public void deleteUserById(Integer id){
        usersRepository.deleteById(id);
    }
    public List<Users> findAll(){
        return usersRepository.findAll();
    }
}
