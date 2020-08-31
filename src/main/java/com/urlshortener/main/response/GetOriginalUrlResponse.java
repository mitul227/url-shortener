package com.urlshortener.main.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class GetOriginalUrlResponse {

    @JsonProperty("original_url")
    private String originalUrl;
}
