dependencies {
    implementation(project(":metplix-core:core-port"))

    implementation("org.springframework.boot:spring-boot-starter-data-jpa") // jpa
    implementation("org.springframework:spring-tx")

    implementation("org.flywaydb:flyway-core")
    implementation("org.flywaydb:flyway-mysql")

    runtimeOnly("com.mysql:mysql-connector-j")
   // runtimeOnly(project(":metplix-core:core-service"))
}

//MySQL(JPA) 관련 어노테이션(@Entity, @Transactional 등) JPA와 트랜잭션 관리가 필요
//spring-boot-starter-data-jpa & spring-tx

//flyway 가지고 데이터베이스 스키마 관리

//데이터베이스가 마이sql로 돌아갈 것임