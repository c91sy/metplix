package com.metplix.client;

import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Component
@RequiredArgsConstructor
public class HttpClient {
    private final RestTemplate restTemplate;

    public String request(String uri, HttpMethod method, HttpHeaders headers, Map<String, Object> params) {
        return restTemplate.exchange(
                uri,
                method,
                new HttpEntity<>(headers),
                new ParameterizedTypeReference<String>() {},
                params
        ).getBody();
    }
}

// 이 클라이언트는 어떠한 요청을 받더라도 다 호출 할 수 있도록 만드는 것
//restTemplate 에 대한 빈을 넣어줘야하기 때문에 별도에 config 생성