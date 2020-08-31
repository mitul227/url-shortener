package com.urlshortener.main.response;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class AddClientResponse {

    @JsonProperty("client_id")
    private String clientId;
}
