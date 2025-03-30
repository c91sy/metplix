package com.metplix.security;

import lombok.Getter;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

@Getter
public class MetplixAuthUser extends User {
    private final String userId;
    private final String userName;
    private final String password;
    private final String email;
    private final String phone;

    public MetplixAuthUser(String userId, String userName, String password, String email, String phone,
                           Collection<? extends GrantedAuthority> authorities) {
        super(email, password, authorities);
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.phone = phone;
    }
}


// @RequiredArgsConstructor
/*Spring Security의 User 클래스를 상속할 때는 기본 생성자를 요구하므로
@RequiredArgsConstructor를 사용할 수 없다.
대신, 자식 클래스에서 부모 클래스의 생성자를 명시적으로 호출하는 생성자를 수동으로 작성해야 함 */