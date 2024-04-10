package com.yzak.spring_buy.repositories;

import com.yzak.spring_buy.entities.Address;
import com.yzak.spring_buy.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address,Long> {
}
