package com.metplix.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing(auditorAwareRef = "requestedByAuditorAware",
                   dateTimeProviderRef = "requestedAtAuditorAware")
//엔티티의 생성 및 수정 시간을 자동으로 추적하고 기록

@Configuration
public class JpaAuditConfig {
}



//JpaAuditConfig 클래스는 JPA 감사 기능을 활성화하고, 감사 정보를 제공할 빈을 설정하는 구성 클래스로
// Spring 컨테이너에 의해 관리되는 빈으로 정의

/*
 auditorAwareRef → 현재 작업 중인 사용자 정보를 자동으로 입력 (@CreatedBy, @LastModifiedBy)
 dateTimeProviderRef → 현재 시간을 자동으로 입력 (@CreatedDate, @LastModifiedDate)
*/

/*  @EnableJpaAuditing 어노테이션을 사용하여
core-service모듈의 audit 패키지 클래스 설정
*/