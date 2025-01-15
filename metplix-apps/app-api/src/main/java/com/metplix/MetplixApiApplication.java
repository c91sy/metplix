package com.metplix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MetplixApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(MetplixApiApplication.class, args);
    }
}
//args를 포함시키면 커맨드라인 인자를 활용할 수 있지만, 지우면 기본 설정으로 애플리케이션이 실행됩니다.

//args를 전달하지 않으면 실행 시 전달된 인자들이 Spring Boot 애플리케이션에 전달되지 않습니다.
//(포트, 프로파일, 환경 설정 등을 커맨드라인 인자로 전달하는 기능이 동작하지 않음, 동적으로 환경을 변경해야 하는 경우 제한적이며
// Spring Boot는 기본적으로 실행 시 동적 설정 변경을 지원하기 때문에 포함하는게 표준)

