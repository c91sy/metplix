dependencies {
    implementation(project(":metplix-core:core-usecase"))
    implementation(project(":metplix-core:core-port"))
    implementation(project(":metplix-commons"))

    implementation(project(":metplix-adapters:adapter-http"))
    implementation(project(":metplix-adapters:adapter-persistence"))
    implementation(project(":metplix-adapters:adapter-redis"))

    implementation("org.springframework:spring-context")
    implementation("org.springframework.data:spring-data-commons")

}

/*샘플 포트로부터 데이터가 필요해서 샘플포트를 바라보게하는데 직접 구현체인클래스(SampleHttpAdapter)를 바로 바라보는게 아니라
SamplePort라고하는 인터페이스를 바로보게 만들었다 */

/* SamplePort 인터페이스를 통해 adapters-http 모듈에 구현된 SampleHttpAdapter와 통신
//runtimeOnly(project(":metplix-adapters:adapter-http"))
runtimeOnly는 모듈을 처음 만들거나 실험할 때, 해당 모듈이 실제로 애플리케이션에서 어떻게 동작하는지를 확인하기 위한 용도로 사용
샘플에서 runtimeOnly를 사용하는 이유는 서비스 모듈(core-service)이 HTTP 구현체(adapter-http)와 강한 결합을 피하기 위해
서비스 모듈이 특정 구현체(SampleHttpAdapter)를 직접 참조하지 않고 인터페이스(SamplePort)만 바라보도록 설계
   */

// 서비스 모듈이 비즈니스 로직에만 집중하고, HTTP 요청/응답 처리는 아답터에서 수행한다면, spring-context를 유지하는 것이 더 적합.
// 이 서비스 모듈은 비즈니스 로직에만 집중하고, HTTP 요청/응답 처리는 아답터모듈(adapters-http)에서 수행

//하지만 서비스 모듈에서 직접 컨트롤러를 작성하거나, 웹 요청 처리 로직이 추가될 계획이 (json처리) 있다면 spring-boot-starter-web로 전환해야 힘
// HTTP 관련 클래스 사용 <@RestController, @RequestMapping, HttpServletRequest 등을 사용하는 경우.


/*
spring-data-commons는 Spring Data의 공통적인 기능과 유틸리티를 제공하는 라이브러리로,
다양한 Spring Data 저장소 구현을 사용할 때 필요한 기본적인 지원을 제공
라이브러리 추가 후 인터페이스 사용 가능 (인터페이스 메서드 생성 가능)
*/