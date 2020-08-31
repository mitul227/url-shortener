package com.urlshortener.main.service;


import com.urlshortener.main.dao.ClientDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientSupportService {

    @Autowired
    private ClientDao clientDao;

    public String addClient(String clientName) {
        return clientDao.addClient(clientName).getClientId();
    }

    public void verifyClientId(String clientId) {
        clientDao.verifyClientId(clientId);
    }
}
