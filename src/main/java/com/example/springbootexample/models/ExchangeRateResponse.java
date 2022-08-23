package com.example.springbootexample.models;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
public class ExchangeRateResponse {
    private String disclaimer;
    private String license;
    private long timestamp;
    private String base;
    private Map<String, Double> rates;

    public double getExchangeRateByCurrency(String currency) {
        return rates.get(currency);
    }
}
