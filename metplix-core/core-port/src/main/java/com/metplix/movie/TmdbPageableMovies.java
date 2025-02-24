package com.metplix.movie;

import lombok.Getter;

import java.util.List;

@Getter
public class TmdbPageableMovies {
    private final List<TmdbMovie> tmdbMovies;
    private final int page;
    private final boolean hasNextPage;
    private final boolean hasPreviousPage;

    public TmdbPageableMovies(List<TmdbMovie> tmdbMovies, int page, boolean hasNextPage, boolean hasPreviousPage) {
        this.tmdbMovies = tmdbMovies;
        this.page = page;
        this.hasNextPage = hasNextPage;
        this.hasPreviousPage = hasPreviousPage;
    }
}