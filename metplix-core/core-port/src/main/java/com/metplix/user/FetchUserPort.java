package com.metplix.user;

import java.util.Optional;

public interface FetchUserPort {
    Optional<UserPortResponse> findByEmail(String email);
}

// 포트에서는 adapter-persistence의 UserRepository 로 가서 db쪽 조회