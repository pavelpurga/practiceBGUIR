package com.example.springweb.repository;

import com.example.springweb.entity.Product;
import com.example.springweb.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsersRepository extends JpaRepository<Users,Integer> {
    List<Users> deleteByName(String name);

    List<Users> findByName(String name);

    Users save(Users users);

    Optional<Users> getUsersById(Integer usersId);
}
