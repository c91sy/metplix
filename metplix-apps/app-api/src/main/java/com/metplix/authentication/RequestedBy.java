package com.metplix.authentication;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor // final 필드에 대한 생성자 자동 생성
public class RequestedBy implements Authentication {

    private final String requestedBy;
}