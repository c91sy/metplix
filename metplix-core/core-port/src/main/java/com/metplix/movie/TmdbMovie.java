package com.metplix.movie;

import lombok.Getter;

@Getter
public class TmdbMovie {
    private  final String movieName;
    private  final Boolean isAdult; //성인여부
    private  final String genre; //장르
    private  final String overview; //설명
    private  final String releaseAt; //출시일자

    public TmdbMovie(String movieName, Boolean isAdult, String genre, String overview, String releaseAt) {
        this.movieName = movieName;
        this.isAdult = isAdult;
        this.genre = genre;
        this.overview = overview;
        this.releaseAt = releaseAt;
    }
}
