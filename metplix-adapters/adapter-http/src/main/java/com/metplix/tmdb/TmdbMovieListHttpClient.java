package com.metplix.tmdb;

import com.metplix.client.TmdbHttpClient;
import com.metplix.movie.TmdbMoviePort;
import com.metplix.movie.TmdbPageableMovies;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.Map;

@Component
public class TmdbMovieListHttpClient implements TmdbMoviePort {

    private final String nowPlayingUrl;

    private final TmdbHttpClient tmdbHttpClient;

    public TmdbMovieListHttpClient(@Value("${tmdb.api.movie-lists.now-playing}") String nowPlayingUrl, TmdbHttpClient tmdbHttpClient) {
        this.nowPlayingUrl = nowPlayingUrl;
        this.tmdbHttpClient = tmdbHttpClient;
    }

    @Override
    public TmdbPageableMovies fetchPageable(int page) {
        String url = nowPlayingUrl + "?language=ko-KR&page=" + page;
        String request = tmdbHttpClient.request(url, HttpMethod.GET, CollectionUtils.toMultiValueMap(Map.of()), Map.of());
        return null;
    }
}
//fetchPageable 메서드를 코어서비스 모듈에서 호출함으로써 TMDB API와의 통신을 더 구조화된 방식으로 관리