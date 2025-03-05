version: '3.8'
services:
mysql:
image: mysql:8.0
container_name: metplix-mysql
ports:
- ':'
environment:
MYSQL_ROOT_PASSWORD: # 비번 설정
MYSQL_DATABASE: # DB 이름 설정
TZ: Asia/Seoul
volumes:
- ./db/mysql/data:/var/lib/mysql
- ./db/mysql/init:/docker-entrypoint-initdb.d
restart: always

redis:
image: redis:alpine
container_name: metplix-redis
hostname: metplix-server
ports:
- 6379:6379
command: redis-server
restart: always
