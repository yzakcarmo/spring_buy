package com.yzak.spring_buy.repositories;

import com.yzak.spring_buy.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
