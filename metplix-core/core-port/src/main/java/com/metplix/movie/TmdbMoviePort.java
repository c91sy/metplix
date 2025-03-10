package com.metplix.movie;

public interface TmdbMoviePort {
    TmdbPageableMovies fetchPageable(int page);
}

//구현체는 아답터모듈 http