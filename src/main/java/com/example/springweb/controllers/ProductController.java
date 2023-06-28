package com.example.springweb.controllers;

import com.example.springweb.DTO.ProductDto;
import com.example.springweb.entity.Brand;
import com.example.springweb.entity.Product;
import com.example.springweb.entity.Type;
import com.example.springweb.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    @Autowired
public ProductController(ProductService productService){
    this.productService = productService;
    }

    @GetMapping
    public  ResponseEntity<List<Product>> getProducts(){
        List<Product> products = productService.findAll();
        return ResponseEntity.ok(products);
    }

    @GetMapping("/{name}")
    public ResponseEntity<List<Product>> showProduct(@PathVariable String name){
        List<Product> products = productService.findProductByName(name);
       return ResponseEntity.ok(products);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Integer id){
        productService.deleteProductById(id);
        return ResponseEntity.ok().build();
    }
    @PostMapping
    public  ResponseEntity<ProductDto> addProduct(@RequestBody Product product){
        ProductDto productDto = new ProductDto();
        productDto.setName(product.getName());
        productDto.setPrice(product.getPrice());
        productDto.setDescription(product.getDescription());
        productDto.setType(product.getType());
        productDto.setBrand(product.getBrand());
        productService.addProducts(product);
        return ResponseEntity.ok(productDto);
    }

    @PutMapping("/{id}")
    public  ResponseEntity<Product> updateProducts(@PathVariable Integer id, @RequestBody Product updatedProduct,Type type,Brand brand){
        Optional<Product> idForSearch= productService.getProductsById(id);
        if(idForSearch.isPresent()){
            Product product = idForSearch.get();
            product.setName(updatedProduct.getName());
            product.setPrice(updatedProduct.getPrice());
            product.setDescription(updatedProduct.getDescription());
            product.getTypes().add(type);
            product.getBrands().add(brand);
            productService.updateProduct(product);
            return ResponseEntity.ok(product);
        }else
         return ResponseEntity.notFound().build();
    }
}
