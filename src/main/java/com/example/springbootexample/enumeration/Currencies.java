package com.example.springbootexample.enumeration;

import lombok.Getter;

@Getter
public enum Currencies {
    RUB("RUB");

    private final String currency;

    Currencies(String currency) {
        this.currency = currency;
    }

}
