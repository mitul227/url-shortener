package com.urlshortener.main.controller;


import com.urlshortener.main.response.GetHitCountResponse;
import com.urlshortener.main.response.GetOriginalUrlResponse;
import com.urlshortener.main.response.GetShortUrlResponse;
import com.urlshortener.main.service.ClientSupportService;
import com.urlshortener.main.service.UrlShortenerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;

@RestController
@Slf4j
public class UrlShortenerController {

    @Autowired
    private UrlShortenerService urlShortenerService;

    @Autowired
    private ClientSupportService clientSupportService;

    @RequestMapping(value = "/get-short-url", method = RequestMethod.GET)
    public GetShortUrlResponse getShortUrl(@RequestParam("longUrl") String longUrl, @RequestHeader("Client-id") String clientId) throws UnsupportedEncodingException {
        log.info("Received req for fetching short url for long url {}", longUrl);
        clientSupportService.verifyClientId(clientId);
        return new GetShortUrlResponse(urlShortenerService.getShortUrl(longUrl, clientId));
    }

    @RequestMapping(value = "/get-original-url", method = RequestMethod.GET)
    public GetOriginalUrlResponse getOriginalUrl(@RequestParam("shortUrl") String shortUrl) {
        log.info("Received req for fetching long url for short url {}", shortUrl);
        return new GetOriginalUrlResponse(urlShortenerService.getOriginalUrl(shortUrl));
    }

    @RequestMapping(value = "/get-hit-count", method = RequestMethod.GET)
    public GetHitCountResponse getHitCount(@RequestParam("shortUrl") String shortUrl) {
        log.info("Received req for fetching hit count for short url {}", shortUrl);
        return new GetHitCountResponse(urlShortenerService.getHitCount(shortUrl));
    }


}
