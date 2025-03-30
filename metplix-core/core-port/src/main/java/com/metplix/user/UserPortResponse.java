package com.metplix.user;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserPortResponse {
    private String userId;
    private String password;
    private String userName;
    private String email;
    private String phone;
    private String provider;
    private String providerId;
    private String role;
}