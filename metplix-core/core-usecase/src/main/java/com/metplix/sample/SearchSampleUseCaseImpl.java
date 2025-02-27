
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

하지만 이 방식은 어려 모듈로 서비스기능을 만든게 아닌 하나의 모듈에 비즈니스로직을 만들어서 빈으로 등록하는 방식이며
만약 생성 할 경우 유스케이스 모듈에서의 이중 의존성 문제가 발생합니다

FetchMovieUseCase 인터페이스는 비즈니스 로직과 직접적인 관련이 있습니다.
이를 구현하려는 구현체가 유스케이스 모듈 내부에 존재할 경우, 다른 모듈과의 의존성 순환 문제가 발생할 수 있습니다.

유스케이스 모듈이 다른 모듈에 의존하고 있고, 반대로 그 모듈이 다시 유스케이스 모듈을 참조하려고 하면 순환 의존성이 발생
이는 주로 모듈 간의 의존성 정의에 따른 문제

*/