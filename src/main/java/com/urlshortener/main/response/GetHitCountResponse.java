package com.urlshortener.main.response;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class GetHitCountResponse {

    @JsonProperty("hit_count")
    private long hitCount;
}
