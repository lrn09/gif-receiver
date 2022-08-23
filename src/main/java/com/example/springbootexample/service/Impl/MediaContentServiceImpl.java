package com.example.springbootexample.service.Impl;

import com.example.springbootexample.client.MediaResponseClient;
import com.example.springbootexample.enumeration.Requests;
import com.example.springbootexample.models.MediaResponse;
import com.example.springbootexample.service.MediaContentService;
import org.springframework.stereotype.Service;

@Service
public class MediaContentServiceImpl implements MediaContentService {

    private final MediaResponseClient mediaResponseClient;

    public MediaContentServiceImpl(MediaResponseClient mediaResponseClient) {
        this.mediaResponseClient = mediaResponseClient;
    }

    @Override
    public MediaResponse getMediaResponseRich() throws Exception {
        return mediaResponseClient.getMediaResponse(Requests.RICH.getRequest());
    }

    @Override
    public MediaResponse getMediaResponseBroke() throws Exception {
        return mediaResponseClient.getMediaResponse(Requests.BROKE.getRequest());

    }
}
