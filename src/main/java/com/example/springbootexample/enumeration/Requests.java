package com.example.springbootexample.enumeration;

import lombok.Getter;

@Getter
public enum Requests {

    RICH("rich"),
    BROKE("broke"),
    RANDOM("random");

    private final String request;

    Requests(String request) {
        this.request = request;
    }

}
