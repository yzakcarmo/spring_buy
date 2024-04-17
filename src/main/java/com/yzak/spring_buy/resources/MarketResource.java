package com.yzak.spring_buy.resources;

import com.yzak.spring_buy.entities.Market;
import com.yzak.spring_buy.services.AddressService;
import com.yzak.spring_buy.services.MarketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/markets")
public class MarketResource {

    @Autowired
    private MarketService service;

    @GetMapping
    public ResponseEntity<List<Market>> findAll() {
        List<Market> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Market> findById(@PathVariable Long id) {
        Market obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<Market> insert(@RequestBody Market obj) {
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
    public ResponseEntity<Market> update(@PathVariable Long id, @RequestBody Market obj) {
        obj = service.update(id, obj);
        return ResponseEntity.ok().body(obj);
    }
}
