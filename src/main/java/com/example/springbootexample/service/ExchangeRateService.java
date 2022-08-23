package com.example.springbootexample.service;

import com.example.springbootexample.models.ExchangeRateResponse;

public interface ExchangeRateService {
    ExchangeRateResponse getCurrentExchangeRateResponse() throws Exception;

    ExchangeRateResponse getPreviousExchangeRateResponse() throws Exception;


}
