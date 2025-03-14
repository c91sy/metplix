package com.metplix.authentication;

import java.util.Optional;

public interface AuthenticationHolder {
    Optional<Authentication> getAuthentication();           // 인증 정보를 가져오는 메서드
    void setAuthentication(Authentication authentication); // 인증 정보를 설정하는 메서드
}
