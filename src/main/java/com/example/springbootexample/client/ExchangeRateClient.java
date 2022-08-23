package com.example.springbootexample.client;

import com.example.springbootexample.models.ExchangeRateResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "Exchanges", url = "${currency_url}")
public interface ExchangeRateClient {

    @GetMapping("/{date}.json?app_id=${currency_api_key}")
    ExchangeRateResponse getExchangeRateResponse(@PathVariable("date") String date) throws Exception;

}
