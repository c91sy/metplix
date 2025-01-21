dependencies {
    implementation(project(":metplix-core:core-usecase"))
    implementation(project(":metplix-core:core-port"))

    runtimeOnly(project(":metplix-adapters:adapter-http"))

    implementation("org.springframework:spring-context")
}

/*샘플 포트로부터 데이터가 필요해서 샘플포트를 바라보게하는데 직접 구현체인클래스(SampleHttpAdapter)를 바로 바라보는게 아니라
SamplePort라고하는 인터페이스를 바로보게 만들었다 */

/* SamplePort 인터페이스를 통해 adapters-http 모듈에 구현된 SampleHttpAdapter와 통신
   runtimeOnly는 해당 의존성을 컴파일 시 포함하지 않고, 애플리케이션 실행 시 주입하여 사용함
   이로써 서비스 모듈은 HTTP 구현체와 직접적으로 강한 의존성을 갖지 않고 느슨한 결합 상태를 유지 */

// 서비스 모듈이 비즈니스 로직에만 집중하고, HTTP 요청/응답 처리는 아답터에서 수행한다면, spring-context를 유지하는 것이 더 적합.
// 이 서비스 모듈은 비즈니스 로직에만 집중하고, HTTP 요청/응답 처리는 아답터모듈(adapters-http)에서 수행

//하지만 서비스 모듈에서 직접 컨트롤러를 작성하거나, 웹 요청 처리 로직이 추가될 계획이 (json처리) 있다면 spring-boot-starter-web로 전환해야 힘
// HTTP 관련 클래스 사용 <@RestController, @RequestMapping, HttpServletRequest 등을 사용하는 경우.