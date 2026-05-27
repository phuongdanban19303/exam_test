package com.example.orderservice.config;

import com.example.orderservice.DTO.ProductResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "inventory-service")
public interface InventoryClient {

    @GetMapping("/api/inventory/{productId}")
    ProductResponse getProductById(@PathVariable("productId") Long productId);
}
