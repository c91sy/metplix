package com.metplix.repository.user;

import com.metplix.entity.user.UserEntity;
import com.metplix.user.FetchUserPort;
import com.metplix.user.UserPortResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class UserRepository implements FetchUserPort {

    private final UserJpaRepository userJpaRepository;

    @Override
    public Optional<UserPortResponse> findByEmail(String email) {
        Optional<UserEntity> byEmail = userJpaRepository.findByEmail(email);
        return byEmail.map(userEntity -> UserPortResponse.builder()
                .userId(userEntity.getUserId())
                .password(userEntity.getPassword())
                .userName(userEntity.getUserName())
                .email(userEntity.getEmail())
                .phone(userEntity.getPhone())
                .build());
    }
}

//데이터가 존재하면 core-port모듈에 있는 <UserPortResponse>로 변환을 하고
// 변환한 값을 findByEmail 를 통해 core-Service 모듈의 UserService에서 받는다