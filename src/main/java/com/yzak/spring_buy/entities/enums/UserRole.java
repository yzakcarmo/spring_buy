package com.yzak.spring_buy.entities.enums;

public enum UserRole {
    CUSTOMER(1),
    SUPPORT(2),
    DELIVERY(3),
    MARKET(4);

    private int code;

    private UserRole(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static UserRole valueOf(int code) {
        for (UserRole value : UserRole.values()) {
            if(value.getCode() == code) return value;
        }
        throw new IllegalArgumentException("Codigo invalido");
    }
}
