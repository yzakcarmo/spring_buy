package com.yzak.spring_buy.services;

import com.yzak.spring_buy.entities.Address;
import com.yzak.spring_buy.entities.Customer;
import com.yzak.spring_buy.repositories.AddressRepository;
import com.yzak.spring_buy.repositories.CustomerRepository;
import com.yzak.spring_buy.services.exceptions.DatabaseException;
import com.yzak.spring_buy.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository repository;

    public List<Customer> findAll() {
        return repository.findAll();
    }

    public Customer findById(Long id) {
        Optional<Customer> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Customer insert(Customer obj) {
        return repository.save(obj);
    }

    public void insertAddress(Long id, Address obj) {
        try {
            Customer entity = repository.getReferenceById(id);
            entity.getAddresses().add(obj);
            repository.save(entity);
        } catch(EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    public List<Address> listAddresses(Long id) {
        Customer entity = repository.getReferenceById(id);
        return entity.getAddresses().stream().toList();
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

    public Customer update(Long id, Customer obj) {
        try {
            Customer entity = repository.getReferenceById(id);
            updateData(entity, obj);
            return repository.save(entity);
        } catch(EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }

    }

    public void updateData(Customer entity, Customer obj) {
        entity.setUser(obj.getUser());
       entity.setBirthDate(obj.getBirthDate());
    }
}
