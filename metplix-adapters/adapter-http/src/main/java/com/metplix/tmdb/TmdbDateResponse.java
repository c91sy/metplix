package com.metplix.tmdb;

import lombok.Getter;

@Getter
public class TmdbDateResponse {
    private String maximum;
    private String minimum;
}

//TMDB API에서 반환되는 날짜 범위 (해당 기간에 개봉된 영화)
// 조회된 영화 중 가장 마지막 개봉일
// 조회된 영화 중 가장 첫 번째 개봉일