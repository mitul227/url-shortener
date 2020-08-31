package com.urlshortener.main.model;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class ClientInfo {
    private String clientName;
    private String clientId;
    private long createdAt;

    public ClientInfo(String clientName){
        this.clientName = clientName;
        this.createdAt = System.currentTimeMillis();
        this.clientId = UUID.randomUUID().toString();
    }
}
