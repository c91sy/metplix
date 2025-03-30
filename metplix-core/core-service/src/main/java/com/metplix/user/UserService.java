package com.metplix.user;

import com.metplix.user.command.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService implements FetchUserUseCase {

    private final FetchUserPort fetchUserPort;

    @Override
    public UserResponse findUserByEmail(String email) {
        Optional<UserPortResponse> byEmail = fetchUserPort.findByEmail(email);
        if (byEmail.isEmpty()) {
            throw new RuntimeException();
        }
        UserPortResponse userPortResponse = byEmail.get();
        return UserResponse.builder()
                .userId(userPortResponse.getUserId())
                .password(userPortResponse.getPassword())
                .userName(userPortResponse.getUserName())
                .email(userPortResponse.getEmail())
                .phone(userPortResponse.getPhone())
                .role(userPortResponse.getRole())
                .build();
    }
}

// usecase 모듈에 있는 FetchUserUseCase를 UserService에서 구현하고 (유저 데이터를 조회)
/*
app-api 모듈의 MetplixUserDetailsService에서 FetchUserUseCase를 이용하여 UserResponse를 가져온 후,
이를 MetplixAuthUser로 변환하여 Spring Security에서 사용할 수 있도록 반환하는 방식
(앱 모듈(app-api)에서 MetplixUserDetailsService가 이를 인증 정보(MetplixAuthUser)로 변환하여 사용하는 구조)
*/

// 서비스에서 db를 조회하려면 port를 바라보게 끔 해야한다
// (findByEmail(email)이메일로 FetchUserPort포트쪽으로 전달)