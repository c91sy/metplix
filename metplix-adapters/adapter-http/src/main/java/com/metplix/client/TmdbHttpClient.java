package com.metplix.client;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.Map;

@Component
@RequiredArgsConstructor
public class TmdbHttpClient {
    private final HttpClient httpClient;

    @Value("${tmdb.auth.access-token}")
    private String accessToken;

    public String request(String uri, HttpMethod method, MultiValueMap<String, String> headers,
                          Map<String, Object> param){
        MultiValueMap<String, String> multiValueMap = new LinkedMultiValueMap<>();
        multiValueMap.add(HttpHeaders.ACCEPT,"application/json");
        multiValueMap.add(HttpHeaders.AUTHORIZATION, "Bearer " + accessToken);
        multiValueMap.addAll(headers);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.addAll(multiValueMap);

        return httpClient.request(uri, method, httpHeaders, param);
    }
}

//HttpClient를 감싸는 TmdbHttpClient

//Tmdb쪽으로 api 호출을 할때 항상 엑세스토큰을 붙여서 호출을 해야해서 별도로 매핑을 하는 클래스를 만듬