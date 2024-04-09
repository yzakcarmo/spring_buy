package com.yzak.spring_buy.services;

import com.yzak.spring_buy.entities.Product;
import com.yzak.spring_buy.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public List<Product> findAll() { return repository.findAll(); }

    public Product findById(Long id) {
        Optional<Product> opt = repository.findById(id);
        return opt.get();
    }
}
