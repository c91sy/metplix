package com.metplix.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {

    DEFAULT_ERROR("MPX0000", "에러가 발생했습니다."),

    PASSWORD_ENCRYPTION_FAILED("MPX1000", "비밀번호 암호화 중 에러가 발생했습니다."),

    USER_ALREADY_EXIST("MPX2000", "사용자가 이미 존재합니다."),
    USER_DOES_NOT_EXIST("MPX2001", "사용자가 존재하지 않습니다."),


    ;

    private final String code;
    private final String desc;

    @Override
    public String toString() {
        return "[" + code + "] " + desc;
    }
}

