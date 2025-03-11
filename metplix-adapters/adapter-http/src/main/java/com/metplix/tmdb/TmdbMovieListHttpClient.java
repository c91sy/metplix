package com.metplix.tmdb;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.metplix.client.TmdbHttpClient;
import com.metplix.movie.TmdbMovie;
import com.metplix.movie.TmdbMoviePort;
import com.metplix.movie.TmdbPageableMovies;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.Map;


@Component
@RequiredArgsConstructor
public class TmdbMovieListHttpClient implements TmdbMoviePort {

    @Value("${tmdb.api.movie-lists.now-playing}")
    private String nowPlayingUrl;
    private final TmdbHttpClient tmdbHttpClient;

    @Override
    public TmdbPageableMovies fetchPageable(int page) {
        String url = nowPlayingUrl + "?language=ko-KR&page=" + page;
        String request = tmdbHttpClient.request(url, HttpMethod.GET,CollectionUtils.toMultiValueMap(Map.of()), Map.of());

        TmdbResponse response;
        try {
            response = new ObjectMapper().readValue(request, TmdbResponse.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        return new TmdbPageableMovies(
                response.getResults().stream().map(movie -> new TmdbMovie(movie.getTitle(),
                        movie.getAdult(), movie.getGenreIds(), movie.getOverview(), movie.getReleaseDate())).toList(),
                page,
                response.getTotalPages() - page != 0,
                page > 1
        ); // 현재페이지가 0일수 없기에 0이 아니면 true, hasPreviousPage: 현재 페이지가 1보다 크면 true
    }
}
//fetchPageable 메서드를 코어서비스 모듈에서 호출함으로써 TMDB API와의 통신을 더 구조화된 방식으로 관리

//movieName은 내가 만든 클래스의 필드 이름이고, getTitle()은 TMDB API에서 가져온 데이터의 필드 이름