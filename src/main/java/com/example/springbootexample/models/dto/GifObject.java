package com.example.springbootexample.models.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
public class GifObject {

    private String type;
    private String id;
    private String url;
    private String slug;
    private Map<String, ImageData> images;

    public ImageData getOriginalImage() {
        return images.get("original");
    }
}
