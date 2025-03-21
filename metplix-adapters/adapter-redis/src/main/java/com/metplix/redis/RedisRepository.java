package com.metplix.redis;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.time.Duration;

@Repository
@RequiredArgsConstructor
public class RedisRepository {
    private final RedisTemplate<String, Object> redisTemplate;
    // Object 타입으로 값을 가져올 때
    public Object getValue(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    // Object 타입을 저장할 때
    public void setValue(String key, Object value) {
        redisTemplate.opsForValue().set(key, value);
    }
    // TTL 설정과 함께 Object 타입을 저장할 때
    public void setValueTtl(String key, String value, Duration ttl) {
        redisTemplate.opsForValue().set(key, value, ttl);
    }
}

/*
getValue와 setValue는 일반적으로 여러 가지 타입을 저장할 수 있으므로 Object 타입을 사용.

setValueTtl에서 String을 사용하는 이유는 액세스 토큰이나 리프레시 토큰은 일반적으로 문자열로 취급되기 때문에
TTL을 설정하여 특정 시간 후에 자동으로 만료되도록 처리
*/

/* redisTemplate 에는 간단한 key, value 형태로만 관리하는 opsForValue 말고도

 opsFor
   "     Hash ,List, Set, ZSet 등이 있다

*/