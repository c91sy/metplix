package com.metplix.audit;

import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class RequestedByAuditorAware implements AuditorAware<String> {

    private final ApplicationContext applicationContext;

    @Override
    public Optional<String> getCurrentAuditor() {

        try {
            return Optional.of(applicationContext.getBean(RequestedByProvider.class)).flatMap(RequestedByProvider::getRequestedBy);
        } catch (Exception e) {
            return Optional.of("system");  // 예외가 발생할 경우 "system"을 반환
        }
    }
}

/*
RequestedByAuditorAware 클래스 이름이 adapter-persistence 모듈의
 JpaAuditConfig클래스의 @EnableJpaAuditing(auditorAwareRef = "requestedByAuditorAware",)
 이 부분 참조
*/
