dependencies {
    implementation(project(":metplix-core:core-port"))
//    implementation(project(":metplix-core:core-domain")) // 도메인 모듈에 대한 의존성 추가

    implementation("org.springframework.boot:spring-boot-starter-web")
}

// 아답터-http와 코어-port 서로 다른 모듈이라 의존성을 정리해 주기 위해 아답터-http의 build.gradle.kts을 사용해야한다
// (애플리케이션의 외부의 인터페이스를 정의하는 부분)