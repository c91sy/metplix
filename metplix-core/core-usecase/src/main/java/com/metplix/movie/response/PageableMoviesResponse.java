package com.metplix.movie.response;

import lombok.Getter;

import java.util.List;

@Getter
public class PageableMoviesResponse {
    private final List<MovieRespons> tmdbMovies;
    private final int page;
    private final boolean hasNextPage;
    private final boolean hasPreviousPage;

    public PageableMoviesResponse(List<MovieRespons> tmdbMovies, int page, boolean hasNextPage, boolean hasPreviousPage) {
        this.tmdbMovies = tmdbMovies;
        this.page = page;
        this.hasNextPage = hasNextPage;
        this.hasPreviousPage = hasPreviousPage;
    }
}