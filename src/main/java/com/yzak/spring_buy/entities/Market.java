package com.yzak.spring_buy.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;

import java.io.Serializable;

public class Market {

    @JsonIgnore
    @OneToOne
    @MapsId
    private User user;

    @OneToOne(mappedBy = "market", cascade = CascadeType.ALL)
    private Address address;

    public Market(){}

    public Address getAddress() {
        return address;
    }
}
