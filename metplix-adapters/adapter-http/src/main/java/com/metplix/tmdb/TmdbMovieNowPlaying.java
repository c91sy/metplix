package com.metplix.tmdb;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.List;

@Getter
public class TmdbMovieNowPlaying {
    private Boolean adult;

    @JsonProperty("backdrop_path")
    private String backdropPath;
    @JsonProperty("poster_path")
    private String posterPath;

    @JsonProperty("genre_ids")
    private List<String> genreIds;

    private Integer id;

    @JsonProperty("original_language")
    private String originalLanguage;

    @JsonProperty("original_title")
    private String originalTitle;
    private String title;

    private String overview;

    private String popularity;

    @JsonProperty("release_date")
    private String releaseDate;

    private String video;

    @JsonProperty("vote_average")
    private String voteAverage;

    @JsonProperty("vote_count")
    private String voteCount;

}

//Java에서는 카멜 케이스를 사용하는 것이 일반적이라
//JSON의 언더바 속성과 매핑하기 위해 @JsonProperty를 사용하여 JSON과 Java 필드 간의 관계를 설정

/*
1. 성인용여부
2. 영화의 큰 배경 이미지 경로 (예: 상세 페이지 상단 배경) 16:9 또는 그와 비슷한 와이드형 비율 <가로형 포스터>
3. 영화 포스터 경로 (공식 포스터) 2:3 <세로형 포스터>
4. 영화의 장르 ID
5. 영화의 고유 ID
6. 영화 사용 언어 (en, ko, zh, ja) 영어, 한국어, 중국어, 일본어
7. 영화의 원래 영어 제목 (예: Frozen -> 겨울왕국)
8. 영화 제목 (각 나라에서 개봉될 때 현지화된 제목 *겨울왕국* 등)
9. 영화의 줄거리
10. 영화 인기도 (예: 350.921) 조회수가 아니라, 다양한 데이터를 반영한 종합적인 "트렌드 지수
(조회수, 검색량, 평점 투표수, 최근등록수치, 리뷰 & 댓글개수, 소셜미디어 언급 수 등 고려)
11. 영화개봉날짜
12. 영화와 관련된 비디오 콘텐츠(예고편, 보너스 클립 등)
13. 영화의 평균 평점
14. 영화 투표 수
*/