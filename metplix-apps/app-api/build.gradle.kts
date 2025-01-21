dependencies {
    implementation(project(":metplix-core:core-usecase"))
    runtimeOnly(project(":metplix-core:core-service"))
    implementation("org.springframework.boot:spring-boot-starter-web")
}

/*단순히 유스케이스 모듈만 바라보는거지만 유스케이스의 구현체인 서비스 모듈을 직접 바라보는건 아니다
그래서 서비스에 대한 의존성을 추가해줘야하지만 서비스를 직접 바라보게 끔 하면 안되고
런타임시에만 참조를 해주게 해야한다 runtimeOnly
 */
