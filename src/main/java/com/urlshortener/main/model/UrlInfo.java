package com.urlshortener.main.model;

import com.urlshortener.main.util.Util;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UrlInfo {

    private static long idTracker = 3521614606208l;
    private String shortUrl;
    private String longUrl;
    private String clientId;
    private long hitCount;
    private long id;
    private long createdAt;


    public UrlInfo(String longUrl, String clientId) {
        synchronized (UrlInfo.class) {
            this.id = idTracker;
            idTracker++;
        }
        this.shortUrl = Util.convertDecimalToBase62(this.id);
        this.longUrl = longUrl;
        this.clientId = clientId;
        this.hitCount = 0;
    }

    public synchronized void incrementHitCount() {
        this.hitCount += 1;
    }

    public synchronized long getHitCount() {
        return this.hitCount;
    }

}
