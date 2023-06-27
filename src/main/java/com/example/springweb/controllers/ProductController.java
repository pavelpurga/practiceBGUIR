package com.example.springweb.controllers;

import com.example.springweb.DTO.ProductDto;
import com.example.springweb.entity.Brand;
import com.example.springweb.entity.Product;
import com.example.springweb.entity.Type;
import com.example.springweb.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Controller
public class ProductController {
    private final ProductService productService;

    @Autowired
public ProductController(ProductService productService){
    this.productService = productService;
    }

    @GetMapping("/productFind")
    public ResponseEntity<List<Product>> showProduct(@RequestParam String name){
        List<Product> products = productService.findProductByName(name);
       return ResponseEntity.ok(products);
    }

    @DeleteMapping("/productDel")
    public ResponseEntity<List<Product>> deleteProduct(@RequestParam String name){
        List<Product> products = productService.deleteProductByName(name);
        return ResponseEntity.ok(products);
    }
    @PostMapping("/productAdd")
    public  ResponseEntity<ProductDto> addProduct(@RequestBody Product product){
        ProductDto productDto = new ProductDto();
        productDto.setName(product.getName());
        productDto.setPrice(product.getPrice());
        productDto.setDescription(product.getDescription());
        productService.addProducts(product);
        return ResponseEntity.ok(productDto);
    }

    @PutMapping("/productUpdate")
    public  ResponseEntity<Product> updateProducts(@RequestParam Integer productId, @RequestBody Product updatedProduct,Type type,Brand brand){
        Optional<Product> idForSearch= productService.getProductsById(productId);
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
