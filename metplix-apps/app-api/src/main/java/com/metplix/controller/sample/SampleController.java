package com.metplix.controller.sample;

import com.metplix.sample.SearchSampleUseCase;
import com.metplix.sample.response.SampleResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
//RESTful 웹 서비스를 쉽게 구현할 수 있도록 도와주는 애너테이션, HTTP 요청을 처리하고 응답을 JSON 형식으로 변환하는 기능을 제공
@RestController
@RequiredArgsConstructor
public class SampleController {

    private final SearchSampleUseCase searchSampleUseCase;

    @GetMapping("api/v1/sample")
    public SampleResponse getSample(){
        return searchSampleUseCase.getSample();
    }
}

/* RestController를 하나 만들고 이 컨트롤러에서는 서비스를 직접 바라보는게 아니라
이 컨트롤러는 유스케이스 모듈의 인터페이스만 바라보며,

서비스 모듈에 대한 직접적인 의존성을 갖지 않는다
서비스 구현체를 런타임 시에만 참조하도록 설정하였으며,build.gradle.kts에 runtimeOnly 의존성을 추가
 */