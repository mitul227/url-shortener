package com.urlshortener.main.controller;

import com.urlshortener.main.response.AddClientResponse;
import com.urlshortener.main.service.ClientSupportService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/client-support")
@Slf4j
public class ClientSupportController {

    @Autowired
    private ClientSupportService clientSupportService;

    /**
     * Can add tokens for verification of internal users hitting this
     * @param clientName
     * @return
     */
    @RequestMapping(value = "/add-client", method = RequestMethod.POST)
    public AddClientResponse addClient(@RequestParam("clientName") String clientName) {
        log.info("Received request for adding client with name {}", clientName);
        return new AddClientResponse(clientSupportService.addClient(clientName));
    }
}
