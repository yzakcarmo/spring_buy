package com.yzak.spring_buy.repositories;

import com.yzak.spring_buy.entities.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem,Long> {
}
