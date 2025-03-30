package com.metplix.user;

import com.metplix.user.command.UserResponse;

public interface FetchUserUseCase {
    UserResponse findUserByEmail(String email);
}
// 이메일을 전달하고