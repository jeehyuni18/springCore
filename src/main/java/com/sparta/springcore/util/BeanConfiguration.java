package com.sparta.springcore.util;

import com.sparta.springcore.repository.ProductRepository;
import com.sparta.springcore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {
//    @Bean
//    public ProductRepository productRepository() {
//        String dbId = "sa";
//        String dbPassword = "";
//        String dbUrl = "jdbc:h2:mem:springcoredb";
//        return new ProductRepository(dbId, dbPassword, dbUrl);
//    }

    @Bean
    @Autowired
    public ProductService productService(ProductRepository productRepository) {
        return new ProductService(productRepository);
    }
}