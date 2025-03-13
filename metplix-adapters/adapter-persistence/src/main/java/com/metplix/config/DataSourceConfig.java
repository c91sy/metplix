package com.metplix.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.hikari")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }
}

//@ConfigurationProperties(prefix = "spring.datasource.hikari")를 사용하면,
//DB 연결 설정을 application.yml에서 관리하고, 코드에서 직접 설정할 필요 없이 자동으로 반영 가능