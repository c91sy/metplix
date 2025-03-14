
## metplix-adapters/adapter-persistence/src/main/resources/adapter-persistence-property.yml

spring:
datasource: # 데이터베이스 관련 설정
hikari: # HikariCP (Spring Boot 기본 커넥션 풀) 설정
jdbc-url: jdbc:mysql://localhost:4001/metplixdb # MySQL 접속 URL (컨테이너의 MySQL 데이터베이스 연결)
driver-class-name: com.mysql.cj.jdbc.Driver # MySQL JDBC 드라이버 클래스
username: root       # MySQL 접속 계정 (루트 사용자)
password:            # MySQL 접속 비밀번호

jpa: # JPA 관련 설정
properties:
hibernate:
format_sql: true # SQL을 보기 좋게 포맷하여 출력 (가독성 향상)
hibernate:
ddl-auto: validate # 기존 DB 스키마를 검증하고 변경하지 않음 (운영 환경에서 권장)
generate-ddl: false # JPA가 DB 테이블을 자동 생성하지 않도록 설정
open-in-view: false # OSIV(Open Session In View) 비활성화 (API 성능 최적화)
show-sql: true # SQL 실행문을 콘솔에 출력 (디버깅 용도)

flyway: # Flyway 마이그레이션 설정 (DB 버전 관리)
locations: classpath:flyway # 마이그레이션 파일 위치 (리소스 폴더의 flyway 디렉터리)
baseline-on-migrate: true # 초기 마이그레이션 시 베이스라인 버전 설정
baseline-version: 1 # 베이스라인 버전 (최초 마이그레이션을 1버전으로 설정)
enabled: true # Flyway 마이그레이션 활성화