package com.example.inventoryservice.respository;
import com.example.inventoryservice.enity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}