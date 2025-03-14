package com.metplix.interceptor;

import com.metplix.authentication.AuthenticationHolder;
import com.metplix.authentication.RequestedBy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.context.request.WebRequestInterceptor;

@Component
@RequiredArgsConstructor // final 필드에 대한 생성자 자동 생성
public class RequestedByInterceptor implements WebRequestInterceptor {

    public static final String REQUESTED_BY_HEADER = "requested-by";
    // HTTP 요청 헤더에서 "requested-by" 값을 가져오기 위한 상수 선언

    private final AuthenticationHolder authenticationHolder;


    @Override
    public void preHandle(WebRequest request) throws Exception {
        String requestedBy = request.getHeader(REQUESTED_BY_HEADER);
        RequestedBy requested = new RequestedBy(requestedBy);
        authenticationHolder.setAuthentication(requested);
    } //헤더 값(requestedBy 값)을 가져와서 객체를 생성하고, 그 객체를 AuthenticationHolder에 저장하는 역할

    @Override
    public void postHandle(WebRequest request, ModelMap model) throws Exception {

    }

    @Override
    public void afterCompletion(WebRequest request, Exception ex) throws Exception {

    }
}
