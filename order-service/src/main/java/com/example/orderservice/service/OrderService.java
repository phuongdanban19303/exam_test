package com.example.orderservice.service;


import com.example.orderservice.DTO.OrderRequest;
import com.example.orderservice.DTO.OrderResponse;
import com.example.orderservice.DTO.ProductResponse;
import com.example.orderservice.config.InventoryClient;
import com.example.orderservice.entity.Order;
import com.example.orderservice.respository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final InventoryClient inventoryClient;

    public OrderResponse createOrder(OrderRequest request) {

        ProductResponse product = inventoryClient.getProductById(request.getProductId());

        if (product == null) {
            throw new RuntimeException("Product not found");
        }

        if (product.getQuantity() < request.getQuantity()) {
            throw new RuntimeException("Not enough inventory");
        }

        BigDecimal totalPrice = product.getPrice()
                .multiply(BigDecimal.valueOf(request.getQuantity()));

        Order order = Order.builder()
                .productId(request.getProductId())
                .quantity(request.getQuantity())
                .status("PENDING")
                .totalPrice(totalPrice)
                .build();

        Order savedOrder = orderRepository.save(order);

        return OrderResponse.builder()
                .id(savedOrder.getId())
                .productId(savedOrder.getProductId())
                .quantity(savedOrder.getQuantity())
                .status(savedOrder.getStatus())
                .totalPrice(savedOrder.getTotalPrice())
                .build();
    }
}