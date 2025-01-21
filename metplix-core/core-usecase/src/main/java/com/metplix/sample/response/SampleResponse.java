package com.metplix.sample.response;

import lombok.Getter;

@Getter
public class SampleResponse {
    private  final String name;

    public SampleResponse(String name) {
        this.name = name;
    }

}

//SampleResponse` 클래스는 검색 결과를 클라이언트에 반환하기 위한 응답 모델로 샘플의 이름을 포함