package com.example.springbootexample.client;

import com.example.springbootexample.models.MediaResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "GIFs", url = "${gif_url}")
public interface MediaResponseClient {

    @GetMapping("/search?q={request}&api_key=${gif_api_key}&limit=5")
    MediaResponse getMediaResponse(@PathVariable("request") String request) throws Exception;

}
