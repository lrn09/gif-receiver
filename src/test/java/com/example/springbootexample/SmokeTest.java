package com.example.springbootexample;

import com.example.springbootexample.controller.ResponseController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class SmokeTest {

    @Autowired
    private ResponseController responseController;

    @Test
    public void ContextLoads() {
        assertThat(responseController).isNotNull();
    }
}
