package com.urlshortener.main.dao;

import com.urlshortener.main.exception.ErrorCode;
import com.urlshortener.main.exception.RecordNotFoundException;
import com.urlshortener.main.model.UrlInfo;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;


@Repository
public class UrlInfoDao {

    private static final String KEY_SEPARATOR = "|";

    Map<Long, UrlInfo> urlInfoMap;
    Map<String, UrlInfo> clientLongUrlIndex;

    @PostConstruct
    public void init() {
        urlInfoMap = new HashMap<>();
        clientLongUrlIndex = new HashMap<>();
    }

    public String findShortUrl(String longUrl, String clientId) {
        String key = getKeyForClientLongUrlIndex(longUrl, clientId);
        if (clientLongUrlIndex.containsKey(key)) {
            return clientLongUrlIndex.get(key).getShortUrl();
        }
        throw new RecordNotFoundException(ErrorCode.long_url_not_found, "Long url " + longUrl + " not found");
    }

    public UrlInfo findUrlInfoById(long id) {
        UrlInfo urlInfo = urlInfoMap.get(id);
        if (urlInfo == null) {
            throw new RecordNotFoundException(ErrorCode.long_url_not_found, "");
        }
        urlInfo.incrementHitCount();
        return urlInfo;
    }

    public long getHitCount(long id) {
        UrlInfo urlInfo = urlInfoMap.get(id);
        if (urlInfo == null) {
            throw new RecordNotFoundException(ErrorCode.short_url_not_found, "");
        }
        return urlInfo.getHitCount();
    }

    public UrlInfo addLongUrl(String longUrl, String clientId) {
        UrlInfo urlInfo = new UrlInfo(longUrl, clientId);
        urlInfoMap.put(urlInfo.getId(), urlInfo);
        clientLongUrlIndex.put(getKeyForClientLongUrlIndex(longUrl, clientId), urlInfo);
        return urlInfo;
    }

    private String getKeyForClientLongUrlIndex(String longUrl, String clientId) {
        return longUrl + KEY_SEPARATOR + clientId;
    }

}
