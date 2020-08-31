package com.urlshortener.main.dao;

import com.urlshortener.main.exception.ClientOnboardingException;
import com.urlshortener.main.exception.ErrorCode;
import com.urlshortener.main.exception.RecordNotFoundException;
import com.urlshortener.main.model.ClientInfo;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Repository
public class ClientDao {

    Map<String, ClientInfo> clientInfoMap;
    Map<String, ClientInfo> clientNameIndex;

    @PostConstruct
    public void init() {
        clientInfoMap = new HashMap<>();
        clientNameIndex = new HashMap<>();
    }

    public ClientInfo addClient(String clientName) {
        if (clientNameIndex.containsKey(clientName)) {
            throw new ClientOnboardingException(ErrorCode.client_already_exists, "Client " + clientName + " already exists");
        }
        ClientInfo clientInfo = new ClientInfo(clientName);
        clientInfoMap.put(clientInfo.getClientId(), clientInfo);
        clientNameIndex.put(clientInfo.getClientName(), clientInfo);
        return clientInfo;
    }

    public void verifyClientId(String clientId) {
        if (!clientInfoMap.containsKey(clientId)) {
            throw new RecordNotFoundException(ErrorCode.invalid_client_id, "Invalid client id " + clientId);
        }
    }
}
