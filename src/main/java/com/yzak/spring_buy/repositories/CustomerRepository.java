package com.yzak.spring_buy.repositories;

import com.yzak.spring_buy.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
}
