package com.sparta.springcore.service;

import com.sparta.springcore.model.Product;
import com.sparta.springcore.dto.ProductMypriceRequestDto;
import com.sparta.springcore.dto.ProductRequestDto;
import com.sparta.springcore.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.sql.SQLException;
import java.util.List;

public class ProductService {
    private final ProductRepository productRepository;
    private static final int MIN_PRICE = 100;

    // 생성자: ProductService() 가 생성될 때 호출됨
    @Autowired
    public ProductService(ProductRepository productRepository) {
        // 멤버 변수 생성
        this.productRepository = productRepository;
    }

    // 회원 ID 로 등록된 모든 상품 조회
    public List<Product> getProducts(Long userId) {
        return productRepository.findAllByUserId(userId);
    }


    @Transactional // 메소드 동작이 SQL 쿼리문임을 선언합니다.
    public Product createProduct(ProductRequestDto requestDto, Long userId ) {
        // 요청받은 DTO 로 DB에 저장할 객체 만들기
        Product product = new Product(requestDto, userId);
        productRepository.save(product);
        return product;
    }

    @Transactional
    public Product updateProduct(Long id, ProductMypriceRequestDto requestDto) {
        Product product = productRepository.findById(id).orElseThrow(
                () -> new NullPointerException("해당 아이디가 존재하지 않습니다.")
        );

        int myPrice = requestDto.getMyprice();
        if (myPrice < MIN_PRICE) {
            throw new IllegalArgumentException("유효하지 않은 관심 가격입니다. 최소 " + MIN_PRICE + " 원 이상으로 설정해 주세요.");
        }

        product.setMyprice(myPrice);
        product.updateMyPrice(myPrice);

        return product;
    }

    // 모든 상품 조회 (관리자용)
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
}




