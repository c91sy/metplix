package com.metplix.audit;

import org.springframework.data.auditing.DateTimeProvider;
import org.springframework.stereotype.Component;

import java.time.ZonedDateTime;
import java.time.temporal.TemporalAccessor;
import java.util.Optional;

@Component
public class RequestedAtAuditorAware implements DateTimeProvider {
    @Override
    public Optional<TemporalAccessor> getNow() {
        return Optional.of(ZonedDateTime.now());
    }
}
// ZonedDateTime 현재 날짜와 시간(시간대)을 반환
//시스템의 지역 시간대에 맞추어진 시간 (국가, 지역)

/*
RequestedAtAuditorAware 클래스 이름이 adapter-persistence 모듈의
 JpaAuditConfig클래스의 @EnableJpaAuditing(dateTimeProviderRef = "requestedAtAuditorAware")
 이 부분 참조
*/