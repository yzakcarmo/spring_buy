package com.yzak.spring_buy.resources;

import com.yzak.spring_buy.entities.Address;
import com.yzak.spring_buy.entities.Customer;
import com.yzak.spring_buy.services.AddressService;
import com.yzak.spring_buy.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/customers")
public class CustomerResource {

    @Autowired
    private CustomerService service;

    @GetMapping
    public ResponseEntity<List<Customer>> findAll() {
        List<Customer> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}/addresses")
    public ResponseEntity<List<Address>> findAll(@PathVariable Long id) {
        List<Address> list = service.listAddresses(id);
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Customer> findById(@PathVariable Long id) {
        Customer obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<Customer> insert(@RequestBody Customer obj) {
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.remove(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping(value = "/{id}")
    public ResponseEntity<Customer> update(@PathVariable Long id, @RequestBody Customer obj) {
        obj = service.update(id, obj);
        return ResponseEntity.ok().body(obj);
    }
}
