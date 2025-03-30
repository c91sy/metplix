package com.metplix.security;

import com.metplix.user.FetchUserUseCase;
import com.metplix.user.command.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails; 기본 스트링클래스 사용 X
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MetplixUserDetailsService implements UserDetailsService {

    private final FetchUserUseCase fetchUserUseCase;

    @Override
    public MetplixAuthUser loadUserByUsername(String email) throws UsernameNotFoundException {
        UserResponse userByEmail = fetchUserUseCase.findUserByEmail(email);
        return new MetplixAuthUser(
                userByEmail.getUserId(),
                userByEmail.getUserName(),
                userByEmail.getPassword(),
                userByEmail.getEmail(),
                userByEmail.getPhone(),
                List.of(new SimpleGrantedAuthority(userByEmail.getRole()))
        );
    }
}

//요청이 들어왔을때 UserDetailsService가 호출이 되고