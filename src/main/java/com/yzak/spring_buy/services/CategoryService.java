package com.yzak.spring_buy.services;

import com.yzak.spring_buy.entities.Category;
import com.yzak.spring_buy.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repository;

    public List<Category> findAll() { return repository.findAll(); }

    public Category findById(Long id) {
        Optional<Category> opt = repository.findById(id);
        return opt.get();
    }
}
