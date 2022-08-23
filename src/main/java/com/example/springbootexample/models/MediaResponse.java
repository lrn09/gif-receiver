package com.example.springbootexample.models;

import com.example.springbootexample.models.dto.GifObject;
import com.example.springbootexample.models.dto.Meta;
import com.example.springbootexample.models.dto.Pagination;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;


@Getter
@Setter
public class MediaResponse {

    private List<GifObject> data;
    private Pagination pagination;
    private Meta meta;

    private GifObject getRandomGifObjectFromList() throws NullPointerException {
        return Objects.requireNonNull(this.data.get(ThreadLocalRandom.current().nextInt(data.size())));
    }

    public String getUrlOfOriginalImage() {
        return getRandomGifObjectFromList()
                .getOriginalImage()
                .getUrl();
    }
}
