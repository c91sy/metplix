package com.metplix.authentication;

import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AuthenticationHolderImpl implements AuthenticationHolder, RequestedByProvider {
    private Authentication authentication;

    @Override
    public Optional<Authentication> getAuthentication() {
        return Optional.ofNullable(authentication); // null 포인트 방지
    }

    @Override
    public void setAuthentication(Authentication authentication) {
        this.authentication = authentication;
    }

    @Override
    public Optional<String> getRequestedBy() {
        return getAuthentication()
                .map(Authentication::getRequestedBy);
    }       // authentication이 null일 때 자동으로 Optional.empty() 반환
}
