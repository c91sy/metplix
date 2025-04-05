package com.metplix.controller;

import com.metplix.exception.ErrorCode;

public record MetplixApiResponse<T>(
        boolean success,
        String code,
        String message,
        T data
) {
    public static final String CODE_SUCCEED = "SUCCEED";

    public static <T> MetplixApiResponse<T> ok(T data) {
        return new MetplixApiResponse<>(true, CODE_SUCCEED, null, data);
    }

    public static <T> MetplixApiResponse<T> fail(ErrorCode errorCode, String message) {
        return new MetplixApiResponse<>(false, errorCode.toString(), message, null);
    }
}

// Metplix프로젝트에서 리턴하는 모든 apiResponse

/*
요청자체가 성공했는지 나타내는 success
코드값
메시지
반환해야하는 데이타



*/