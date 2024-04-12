package com.yzak.spring_buy.repositories;

import com.yzak.spring_buy.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
