package com.metplix.sample;

import com.metplix.sample.response.SampleResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SampleService implements SearchSampleUseCase{

    private final SamplePort samplePort; // SamplePort를 통해 아답터와 통신
    //private final SamplePersistencePort samplePersistencePort;
    //SamplePersistencePort는 현재 포트폴리오에 포함되지 않는 엔티티와 리포지토리 코드로 인해 주석 처리했습니다.

    @Override
    public SampleResponse getSample() {
        SamplePortResponse sample = samplePort.getSample();
        //String sampleName = samplePersistencePort.getSampleName("1");
        return new SampleResponse(sample.getName());
    }
}
/*샘플 포트로부터 데이터가 필요해서 샘플포트를 바라보게하는데 직접 구현체인클래스(SampleHttpAdapter)를 바로 바라보는게 아니라
SamplePort라고하는 인터페이스를 바로보게 만들었다 */

// 아답터모듈영역의 SampleHttpAdapter 통해 외부 시스템과 통신
// app-api 모듈의 SampleController가 샘플 서비스를 호출하고 검색 비즈니스 로직을 처리하는 서비스 클래스
// 아답터를 통해 얻은 데이터를 기반으로 결과를 반환

//core-usecase 모듈의 인터페이스를 가져와 해당 비즈니스 로직을 정의
//core-port 모듈의 인터페이스(SamplePort)를 통해 외부 아답터와의 의존성을 관리

//샘플 포트로부터 데이터가 필요해서 샘플포트를 바라보게하는데
/*  포트를 호출하여 아답터에서 데이터를 가져오고, 해당 데이터를 가공하여 SampleResponse 객체로 반환
    포트에서 가져온 데이터 객체
    가져온 데이터를 가공하여 SampleResponse 객체 생성 후 반환 */

//샘플 서비스를 호출하는 컨트롤러 필요 metplix-apps 모듈에 존재