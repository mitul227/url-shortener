package com.urlshortener.main.service;

import com.urlshortener.main.dao.UrlInfoDao;
import com.urlshortener.main.exception.ErrorCode;
import com.urlshortener.main.exception.InvalidLongUrlException;
import com.urlshortener.main.exception.RecordNotFoundException;
import com.urlshortener.main.util.Util;
import org.apache.commons.validator.routines.UrlValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

@Service
public class UrlShortenerService {

    private static final String MY_SERVICE_DOMAIN = "http://chotu.io/";

    @Autowired
    private UrlInfoDao urlInfoDao;

    public String getShortUrl(String longUrl, String clientId) throws UnsupportedEncodingException {
        String decodedUrl = "";
        try {
            decodedUrl = verifyAndDecodeUrl(longUrl);
            return MY_SERVICE_DOMAIN + urlInfoDao.findShortUrl(decodedUrl, clientId);
        } catch (RecordNotFoundException e) {
            return MY_SERVICE_DOMAIN + urlInfoDao.addLongUrl(decodedUrl, clientId).getShortUrl();
        }
    }

    public String getOriginalUrl(String shortUrl) {
        return urlInfoDao.findUrlInfoById(Util.convertBase62ToDecimal(shortUrl)).getLongUrl();
    }

    public long getHitCount(String shortUrl) {
        return urlInfoDao.getHitCount(Util.convertBase62ToDecimal(shortUrl));
    }

    /***
     * Finds whether a url is valid or not and returns it's decoded form
     * Right now UrlValidator of apache commons is used with not so much flexible settings
     * Better to create a Custom Url Validator that allows more flexibility
     * Cases to handle -
     * 1) providing random string like "hello" in long url
     * 2) providing already shortened links using this service
     * 3) handling flexibility when protocol is missing from a url
     * @param longUrl
     * @return
     */
    public String verifyAndDecodeUrl(String longUrl) throws UnsupportedEncodingException {
        String decodedUrl = URLDecoder.decode(longUrl, "UTF-8");
        UrlValidator urlValidator = new UrlValidator();
        if (urlValidator.isValid(decodedUrl)) {
            return decodedUrl;
        }
        throw new InvalidLongUrlException(ErrorCode.invalid_long_url, "Invalid long url " + longUrl);
    }

}
