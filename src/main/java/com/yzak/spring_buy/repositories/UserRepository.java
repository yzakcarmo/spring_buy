package com.yzak.spring_buy.repositories;

import com.yzak.spring_buy.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
