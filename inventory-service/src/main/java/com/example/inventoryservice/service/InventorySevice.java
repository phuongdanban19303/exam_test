package com.example.inventoryservice.service;

import com.example.inventoryservice.DTO.ProductResponse;
import com.example.inventoryservice.enity.Product;
import com.example.inventoryservice.respository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InventorySevice {
    private final ProductRepository productRepository;
    public ProductResponse getProductByProductId(Long productId) {
        Product product = productRepository.findById(productId).orElseThrow(()->new RuntimeException("k tim tha") );
        return ProductResponse.builder().id(product.getId()).productName(product.getProductName()).quantity(product.getQuantity()).price(product.getPrice()).build();
    }
}
