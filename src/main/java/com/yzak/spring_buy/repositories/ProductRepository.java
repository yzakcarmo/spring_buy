package com.yzak.spring_buy.repositories;

import com.yzak.spring_buy.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
