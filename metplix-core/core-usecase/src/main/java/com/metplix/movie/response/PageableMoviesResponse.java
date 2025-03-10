package com.metplix.movie.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Getter
@RequiredArgsConstructor // final 필드에 대한 생성자 자동 생성
public class PageableMoviesResponse {
    private final List<MovieRespons> tmdbMovies;
    private final int page;
    private final boolean hasNextPage;
    private final boolean hasPreviousPage;
}
