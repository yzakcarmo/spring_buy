package com.yzak.spring_buy.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.yzak.spring_buy.entities.enums.UserRole;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_customer")
public class Customer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate birthDate;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

//    @JsonIgnore
//    @OneToMany(mappedBy = "customer")
//    private List<Order> orders = new ArrayList<>();

    public Customer(){}

    public Customer(Long id, User user, LocalDate birthDate) {
        this.id = id;
        this.user = user;
        this.birthDate = birthDate;
        user.setRole(UserRole.CUSTOMER);
    }

//    public Customer(Long id, LocalDate birthDate) {
//        this.id = id;
//        this.birthDate = birthDate;
//    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

//    public List<Order> getOrders() {
//        return orders;
//    }
}
