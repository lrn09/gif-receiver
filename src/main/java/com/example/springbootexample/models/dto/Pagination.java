package com.example.springbootexample.models.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Pagination {

    private int totalCount;
    private int count;
    private int offset;
}
