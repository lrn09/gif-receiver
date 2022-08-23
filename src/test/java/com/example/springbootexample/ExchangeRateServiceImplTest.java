package com.example.springbootexample;

import com.example.springbootexample.service.ExchangeRateService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;


@SpringBootTest
public class ExchangeRateServiceImplTest {

    @SpyBean
    ExchangeRateService service;

    @Test
    public void responseIsNotEqual() throws Exception {
        Assertions.assertNotEquals(service.getCurrentExchangeRateResponse(), service.getPreviousExchangeRateResponse());
    }
}
