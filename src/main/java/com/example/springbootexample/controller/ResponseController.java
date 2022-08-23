package com.example.springbootexample.controller;


import com.example.springbootexample.enumeration.Currencies;
import com.example.springbootexample.service.ExchangeRateService;
import com.example.springbootexample.service.MediaContentService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.cloud.openfeign.FeignClientsConfiguration;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URL;
import java.util.Objects;


@RestController
@Import(FeignClientsConfiguration.class)
public class ResponseController {
    private final ExchangeRateService exchangeRateService;
    private final MediaContentService mediaContentService;

    public ResponseController(ExchangeRateService exchangeRateService, MediaContentService mediaContentService) {
        this.exchangeRateService = exchangeRateService;
        this.mediaContentService = mediaContentService;
    }


    private boolean hasExchangeRateGrown() throws Exception {
        return exchangeRateService.getCurrentExchangeRateResponse()
                .getExchangeRateByCurrency(Currencies.RUB.getCurrency()) >
                exchangeRateService.getPreviousExchangeRateResponse()
                        .getExchangeRateByCurrency(Currencies.RUB.getCurrency());
    }

    private String getUrlOfGifRepresentation() throws Exception {
        return (hasExchangeRateGrown()) ?
                mediaContentService.getMediaResponseRich().getUrlOfOriginalImage()
                : mediaContentService.getMediaResponseBroke().getUrlOfOriginalImage();
    }

    @GetMapping(value = "/", produces = MediaType.IMAGE_GIF_VALUE)
    public byte[] getGifImage() throws Exception {
        Document doc = Jsoup.connect(getUrlOfGifRepresentation()).get();
        String gifOriginalUrl = Objects.requireNonNull(doc.select("meta[property=og:url]").first()).attr("content");
        return StreamUtils.copyToByteArray(new URL(gifOriginalUrl).openStream());
    }
}

