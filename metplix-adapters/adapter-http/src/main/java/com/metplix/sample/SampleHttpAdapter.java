package com.metplix.sample;

import org.springframework.stereotype.Repository;

@Repository //스프링에서 관리하는 빈으로 등록
public class SampleHttpAdapter implements SamplePort{
    @Override
    public SamplePortResponse getSample(){
        return new SamplePortResponse("hello");
    }
}

//아답터 쪽에서 sample 도메인에 대한 의존성이 없어서 문제가 생길때 해결방법 2가지

// 1. 아답터-http의 build.gradle.kts에서 의존성 설정하거나
/*
public com.metplix.sample.Sample getSample(){
    return null;
   }
*/

/* 2. 포트레벨에서 관리하는 코어-포트 모듈의 sample 패키지에 SamplePort 인터페이스를 두고
도메인 객체를 반환하는 메서드를 포함시킴으로써 아답터와 도메인 간의 의존성을 명확히 설정
SampleResponse` 클래스를 추가하여, 아답터에서 도메인 객체를 반환할 때 사용하는 응답 모델을 정의

public sample getSample(){
    return null;
   }
*/

//단순한 설정: 첫 번째 방법을 사용하여 빠르고 간편하게 구현함.
//복잡한 기능: 두 번째 방법을 사용하여 아답터와 도메인 간의 관계를 명확히 하고, 유지보수를 용이하게 함.