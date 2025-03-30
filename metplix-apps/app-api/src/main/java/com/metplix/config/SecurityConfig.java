package com.metplix.config;

import com.metplix.security.MetplixUserDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

import java.util.Collections;


@Configuration
@EnableWebSecurity //웹 보안을 설정하는 어노테이션 HTTP 요청에 대한 보안 설정을 담당
@EnableMethodSecurity //메서드 보안을 설정, 서비스나 비즈니스 로직 계층에서 메서드 수준에서의 인증 및 인가를 제어
@RequiredArgsConstructor
public class SecurityConfig {
    private final MetplixUserDetailsService metplixUserDetailsService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.httpBasic(AbstractHttpConfigurer::disable);
        http.csrf(AbstractHttpConfigurer::disable);
        http.formLogin(AbstractHttpConfigurer::disable);
        http.cors(cors -> cors.configurationSource(corsConfigurationSource()));

        http.userDetailsService(metplixUserDetailsService);

        http.authorizeHttpRequests(authorizeRequests ->
                authorizeRequests.anyRequest().authenticated());  //요청에 대한 인가 설정

        http.oauth2Login(oauth2 ->
                oauth2.failureUrl("/login?error=true")
        );

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    public CorsConfigurationSource corsConfigurationSource() {
        return request -> {
            CorsConfiguration configuration = new CorsConfiguration();
            configuration.setAllowedHeaders(Collections.singletonList("*"));
            configuration.setAllowedMethods(Collections.singletonList("*"));
            configuration.setAllowedOriginPatterns(Collections.singletonList("*"));
            configuration.setAllowCredentials(true);
            return configuration;
        };
    }
}

/*
JWT (JSON Web Token) 또는 OAuth2와 같은 다른 인증 방식을 사용하려는 경우
기본적으로 제공되는 인증 방식인 HTTP Basic Authentication, 폼 로그인, CSRF 보호를 비활성화하는 것이 일반적
단
클라이언트와 서버 간의 통신을 가능하게 하고, 보안을 강화하기 위해 CORS를 활성화하는 것이 중요.
이는 인증 방식과는 별개로, API 접근을 허용하기 위한 설정
CorsConfigurationSource 메서드를 만든 이유는 CORS 설정을 중앙에서 관리하고 재사용할 수 있도록 하기 위해서
*/