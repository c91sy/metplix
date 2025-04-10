package com.metplix.user.command;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
@Builder
public class UserResponse {
    private final String userId;
    private final String password;
    private final String userName;
    private final String email;
    private final String phone;
    private final String provider;
    private final String providerId;
    private final String role;
}
