dependencies {
    implementation(project(":metplix-core:core-usecase"))
    implementation(project(":metplix-core:core-service"))
    implementation("org.springframework.boot:spring-boot-starter-web")
}

/*
runtimeOnly(project(":metplix-core:core-service"))
유스케이스 모듈은 서비스 모듈의 구현체를 직접 참조하지 않으며,
서비스 모듈에 대한 의존성을 추가하되, 런타임에만 필요하도록 설정한다.
이렇게 하면 유스케이스가 서비스의 인터페이스에만 의존하게 되어 결합도를 낮출 수 있다.

초기 테스트 단계에서는 런타임 의존성을 사용하여 유스케이스와 서비스 간의 상호작용을 검증할 수 있다.
하지만 본격적으로 프로젝트를 진행할 때는 서비스 모듈을 `implementation`으로 변경하여,
유스케이스가 서비스의 구현체를 컴파일 타임에도 참조할 수 있도록 해야 한다.
이렇게 하면 전체 애플리케이션의 구조가 명확해지고, 의존성 관리가 용이해진다.
*/