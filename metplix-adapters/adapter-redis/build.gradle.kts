dependencies {
    implementation(project(":metplix-core:core-port"))

    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-data-redis")
}

/*
spring-boot-starter-data-redis
Redis와의 통신을 쉽게 할 수 있도록 지원하는 라이브러리
RedisTemplate, StringRedisTemplate 같은 Redis 클라이언트 기능 제공
캐싱(@Cacheable), 세션 저장소, 메시지 큐(Pub/Sub) 등 Redis 관련 기능을 사용하려면 필수
*/