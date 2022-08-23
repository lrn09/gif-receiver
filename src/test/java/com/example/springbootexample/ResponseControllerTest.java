package com.example.springbootexample;

import com.example.springbootexample.controller.ResponseController;
import com.example.springbootexample.service.Impl.ExchangeRateServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ResponseControllerTest {

    @Autowired
    MockMvc mockMvc;
    @SpyBean
    ResponseController controller;
    @SpyBean
    ExchangeRateServiceImpl service;

    @Test
    public void getResponse() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().isOk());
    }

    @Test
    public void getGifMediaType() throws Exception {
        mockMvc.perform(
                        get("/"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.IMAGE_GIF));
    }

}
