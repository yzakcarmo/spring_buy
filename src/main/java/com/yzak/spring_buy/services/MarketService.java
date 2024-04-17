package com.yzak.spring_buy.services;

import com.yzak.spring_buy.entities.Market;
import com.yzak.spring_buy.entities.Market;
import com.yzak.spring_buy.repositories.MarketRepository;
import com.yzak.spring_buy.services.exceptions.DatabaseException;
import com.yzak.spring_buy.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MarketService {

    @Autowired
    private MarketRepository repository;

    public List<Market> findAll() { return repository.findAll(); }

    public Market findById(Long id) {
        Optional<Market> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Market insert(Market obj) {
        return repository.save(obj);
    }

    public void remove(Long id) {
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    public Market update(Long id, Market obj) {
        try {
            Market entity = repository.getReferenceById(id);
            updateData(entity, obj);
            return repository.save(entity);
        } catch(EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }

    }

    public void updateData(Market entity, Market obj) {
        entity.setUser(obj.getUser());
        entity.setAddress(obj.getAddress());
    }
}
