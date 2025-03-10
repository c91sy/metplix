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

/* response 패키지는 일반적으로 웹 애플리케이션에서 클라이언트의 요청에 대한 응답을 처리하는데
    관련된 클래스를 포함하는 패키지를 의미 */