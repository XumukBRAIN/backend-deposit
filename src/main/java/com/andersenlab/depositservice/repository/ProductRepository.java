package com.andersenlab.depositservice.repository;

import com.andersenlab.depositservice.domain.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> {
}
