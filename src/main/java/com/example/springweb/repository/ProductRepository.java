package com.example.springweb.repository;

import com.example.springweb.DTO.ProductDto;
import com.example.springweb.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {
 void deleteById(Integer id);
 List<Product> findByName(String name);

 Product save(Product product);

 Optional<Product> findById(Integer productId);

 List<Product> findAll();
 Optional<Product> getProductsById(Integer productId);

}