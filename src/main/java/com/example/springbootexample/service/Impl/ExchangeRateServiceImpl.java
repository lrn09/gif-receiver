package com.example.springbootexample.service.Impl;

import com.example.springbootexample.client.ExchangeRateClient;
import com.example.springbootexample.models.ExchangeRateResponse;
import com.example.springbootexample.service.ExchangeRateService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class ExchangeRateServiceImpl implements ExchangeRateService {

    private final ExchangeRateClient exchangeRateClient;

    public ExchangeRateServiceImpl(ExchangeRateClient exchangeRateClient) {
        this.exchangeRateClient = exchangeRateClient;
    }

    @Override
    public ExchangeRateResponse getCurrentExchangeRateResponse() throws Exception {
        return exchangeRateClient.getExchangeRateResponse(LocalDate.now().toString());
    }

    @Override
    public ExchangeRateResponse getPreviousExchangeRateResponse() throws Exception {
        return exchangeRateClient.getExchangeRateResponse(LocalDate.now().minusDays(1).toString());
    }

}
