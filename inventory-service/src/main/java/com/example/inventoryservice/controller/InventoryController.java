package com.example.inventoryservice.controller;

import com.example.inventoryservice.DTO.ProductResponse;
import com.example.inventoryservice.service.InventorySevice;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/inventory")
@RequiredArgsConstructor
public class InventoryController {
    private final InventorySevice inventorySevice;
    @GetMapping("/{productId}")
    public ResponseEntity<ProductResponse> getProduct(@PathVariable Long productId) {
    return  ResponseEntity.ok(inventorySevice.getProductByProductId(productId));}
}
