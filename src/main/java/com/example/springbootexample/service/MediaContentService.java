package com.example.springbootexample.service;

import com.example.springbootexample.models.MediaResponse;

public interface MediaContentService {

    MediaResponse getMediaResponseRich() throws Exception;

    MediaResponse getMediaResponseBroke() throws Exception;
}
