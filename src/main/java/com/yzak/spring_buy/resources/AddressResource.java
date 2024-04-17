package com.yzak.spring_buy.resources;

import com.yzak.spring_buy.entities.Address;
import com.yzak.spring_buy.entities.Address;
import com.yzak.spring_buy.services.AddressService;
import com.yzak.spring_buy.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/addresses")
public class AddressResource {

    @Autowired
    private AddressService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Address> findById(@PathVariable Long id) {
        Address obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping(value = "/customer/{id}")
    public ResponseEntity<Address> insertCustomer(@PathVariable Long id, @RequestBody Address obj) {
        obj = service.insertCustomer(id, obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

    @PostMapping(value = "/market/{id}")
    public ResponseEntity<Address> insertMarket(@PathVariable Long id, @RequestBody Address obj) {
        obj = service.insertMarket(id, obj);
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
    public ResponseEntity<Address> update(@PathVariable Long id, @RequestBody Address obj) {
        obj = service.update(id, obj);
        return ResponseEntity.ok().body(obj);
    }
}
