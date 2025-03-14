package com.metplix.config;

import com.metplix.interceptor.RequestedByInterceptor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Component
@EnableWebMvc // Spring MVC의 설정을 활성화하여, 웹 관련 설정을 구성할 수 있게 해주는 어노테이션
@RequiredArgsConstructor // final 필드에 대한 생성자 자동 생성
public class RequestedByMvcConfigurer implements WebMvcConfigurer {
    private final RequestedByInterceptor requestedByInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addWebRequestInterceptor(requestedByInterceptor);
    }
}
