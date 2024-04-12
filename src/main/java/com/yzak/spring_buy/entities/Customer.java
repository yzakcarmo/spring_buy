package com.yzak.spring_buy.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.yzak.spring_buy.entities.enums.UserRole;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;

import java.time.LocalDate;

public class Customer{

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
    private LocalDate birthDate;

    @JsonIgnore
    @OneToOne
    @MapsId
    private User user;

    public Customer(){}

    public Customer(User user, LocalDate birthDate) {
        this.user = user;
        this.birthDate = birthDate;
        user.setRole(UserRole.CUSTOMER.getCode());
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public User getUser() {
        return user;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
}
