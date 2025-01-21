package com.metplix.sample;

public interface SamplePort {
    SamplePortResponse getSample(); // Sample 도메인 객체를 반환하는 메서드
}
//Sample의 의존성이 설정 되지 않던 이유
// 코어 port와 domain 서로 다른 모듈이라 의존성을 정리해 주기 위해 core포트의 build.gradle.kts을 사용해야한다
// (애플리케이션의 외부의 인터페이스를 정의하는 부분)
