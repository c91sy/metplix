package com.metplix.sample;

import com.metplix.sample.response.SampleResponse;

public interface SearchSampleUseCase {
    SampleResponse getSample();
}

//SearchSampleUseCase` 인터페이스는 샘플 정보를 검색하는 유스케이스를 표현하며,
//`getSample()` 메서드는 샘플 정보를 반환

//유스케이스는 서비스에서 구현체를 만들고 컨트롤러에서 직접바라보는게 아니라 인터페이스만 바라보게 해두고