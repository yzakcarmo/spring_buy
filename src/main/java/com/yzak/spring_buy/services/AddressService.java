package com.yzak.spring_buy.services;

import com.yzak.spring_buy.entities.Address;
import com.yzak.spring_buy.entities.Customer;
import com.yzak.spring_buy.entities.Market;
import com.yzak.spring_buy.repositories.AddressRepository;
import com.yzak.spring_buy.repositories.CustomerRepository;
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
public class AddressService {

    @Autowired
    private AddressRepository repository;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private MarketService marketService;

    public List<Address> findAll() { return repository.findAll(); }

    public Address findById(Long id) {
        Optional<Address> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Address insert(Address obj) {
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

    public Address update(Long id, Address obj) {
        try {
            Address entity = repository.getReferenceById(id);
            updateData(entity, obj);
            return repository.save(entity);
        } catch(EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }

    }

    public void updateData(Address entity, Address obj) {
        entity.setCity(obj.getCity());
        entity.setComplement(obj.getComplement());
        entity.setDistrict(obj.getDistrict());
        entity.setNumber(obj.getNumber());
        entity.setPostalCode(obj.getPostalCode());
        entity.setStreet(obj.getStreet());
        entity.setState(obj.getState());
    }
}
