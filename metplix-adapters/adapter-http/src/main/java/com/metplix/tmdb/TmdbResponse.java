package com.metplix.tmdb;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.List;

@Getter
//TmdbResponse 전체 영화 데이터
public class TmdbResponse {
    private TmdbDateResponse dates;
    private String page;

    @JsonProperty("total_pages")
    private int totalPages;

    @JsonProperty("total_results")
    private int totalResults;
    private List<TmdbMovieNowPlaying> results;
}

/*
영화 데이터의 날짜 정보
현재 페이지 번호
API 응답에서 총 페이지 수
API 응답에서 총 결과 수
*/