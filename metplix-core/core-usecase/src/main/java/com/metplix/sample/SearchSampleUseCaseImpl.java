
package com.metplix.sample;
/*
import com.metplix.sample.response.SampleResponse;
import org.springframework.stereotype.Service;

@Service  // 빈으로 등록
public class SearchSampleUseCaseImpl implements SearchSampleUseCase {

    @Override
    public SampleResponse getSample() {
        // 예시 응답
        return new SampleResponse("Sample");
    }
}
*/

/*
Spring Boot 3.4 이후부터는 서비스 구현체를 빈으로 등록하기 위해 @Service을 사용해야 합니다.
이전 버전에서는 인터페이스만으로도 빈이 등록되는 경우가 있었지만,
Spring Boot 3.4에서는 인터페이스만으로는 자동 빈 등록이 되지 않고,
구현체 클래스를 명시적으로 빈으로 등록해야 합니다.

하지만 이 방식은 어려 모듈로 서비스기능을 만든게 아닌 하나의 모듈에 비즈니스로직을 만들어서 빈으로 등록하는 방식
*/