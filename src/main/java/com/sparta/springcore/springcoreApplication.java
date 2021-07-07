package com.sparta.springcore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing // 시간 자동 변경이 가능하도록 합니다.
@ServletComponentScan
public class springcoreApplication {
    public static void main(String[] args) {
        // 개발자가 원래 수동으로 해야 되는 작업 (Dependency Injection) -> Spring 이 대신 해줌
//        String dbId = "sa";
//        String dbPassword = "";
//        String dbUrl = "jdbc:h2:mem:springcoredb";
//        ProductRepository productRepository = new ProductRepository(dbId, dbPassword, dbUrl);
//
//        ProductService productService = new ProductService(productRepository);
//
//        ProductController productController = new ProductController(productService);

        SpringApplication.run(springcoreApplication.class, args);
    }

}
