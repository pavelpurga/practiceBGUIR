package com.example.springweb;

import com.example.springweb.entity.Product;
import static org.junit.Assert.assertThat;
import com.example.springweb.repository.ProductRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class ProductRepositoryTests {
    @Autowired
    private ProductRepository productRepository;

    @Test
    public void testAddNew(){
        Product product = new Product();
        product.setName("Galaxy A15");
        product.setPrice(114124);
        product.setDescription("tut pusto");

  //        Assertions.assertThat(savedProduct).isNotNull();
  //      Assertions.assertThat(savedProduct.getId()).isGreaterThan(0);
    }
}
