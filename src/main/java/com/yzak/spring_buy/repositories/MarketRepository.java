package com.yzak.spring_buy.repositories;

import com.yzak.spring_buy.entities.Category;
import com.yzak.spring_buy.entities.Market;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MarketRepository extends JpaRepository<Market,Long> {
}
