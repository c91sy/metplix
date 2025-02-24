package com.metplix.movie;

import com.metplix.movie.response.PageableMoviesResponse;

public interface FetchMovieUseCase {
    //영화 데이터를 tmdb와 db에서도 가져 올 수 있다
    PageableMoviesResponse fetchFromClient(int page);
}
