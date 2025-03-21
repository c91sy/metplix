# metplix-apps/app-api/src/main/resources/application.yml

spring:
config:
import:
- 'classpath:adapter-http-property.yml'
- 'classpath:adapter-persistence-property.yml'
- 'classpath:adapter-redis-property.yml'