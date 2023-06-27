package com.example.springweb.service;

import com.example.springweb.entity.Brand;
import com.example.springweb.entity.Product;
import com.example.springweb.entity.Type;
import com.example.springweb.repository.BrandRepository;
import com.example.springweb.repository.ProductRepository;
import com.example.springweb.repository.TypeRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;


@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final TypeRepository typeRepository;
    private final BrandRepository brandRepository;

    @Autowired
    public ProductService(ProductRepository productRepository, TypeRepository typeRepository, BrandRepository brandRepository) {
        this.productRepository = productRepository;
        this.typeRepository = typeRepository;
        this.brandRepository = brandRepository;
    }

    public List<Product> findProductByName(String name) {
        return productRepository.findByName(name);
    }

    @Transactional
    public List<Product> deleteProductByName(String name) {
        return productRepository.deleteByName(name);
    }

    public Product addProducts(Product product) {
        return productRepository.save(product);
    }

    public Product updateProduct(Product product) {
        return productRepository.save(product);
    }


    public Optional<Product> getProductsById(Integer productId){
       return productRepository.getProductsById(productId);
    }
}
