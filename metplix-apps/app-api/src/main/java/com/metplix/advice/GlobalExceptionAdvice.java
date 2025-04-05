package com.metplix.advice;

import com.metplix.controller.MetplixApiResponse;
import com.metplix.exception.ErrorCode;
import com.metplix.exception.UserException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionAdvice {

    @ExceptionHandler(UserException.class)
    protected MetplixApiResponse<?> handleUserException(UserException e) {
        log.error(e.getMessage(), e);
        return MetplixApiResponse.fail(e.getErrorCode(), e.getMessage());
    }

    @ExceptionHandler(RuntimeException.class)
    protected MetplixApiResponse<?> handleRuntimeException(RuntimeException e) {
        log.error(e.getMessage(), e);
        return MetplixApiResponse.fail(ErrorCode.DEFAULT_ERROR, e.getMessage());
    }

}
