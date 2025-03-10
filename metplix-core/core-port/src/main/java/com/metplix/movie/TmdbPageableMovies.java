package com.metplix.movie;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Getter
@RequiredArgsConstructor // final 필드를 위한 생성자 자동 생성
public class TmdbPageableMovies {
    private final List<TmdbMovie> tmdbMovies;
    private final int page;
    private final boolean hasNextPage;
    private final boolean hasPreviousPage;
}
