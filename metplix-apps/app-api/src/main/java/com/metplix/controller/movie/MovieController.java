package com.metplix.controller.movie;

import com.metplix.movie.FetchMovieUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MovieController {
    private final FetchMovieUseCase fetchMovieUseCase;

    @GetMapping("/api/v1/movie/client/{page}")
    public String fetchMovieClient(@PathVariable int page) {
        fetchMovieUseCase.fetchFromClient(page);
        return "";
    }
}

//app-api모듈 (컨트롤러) → core-usecase모듈 (무비 패키지 인터페이스) -> core-service모듈(비즈니스로직) →
//포트( TmdbMoviePort ) → 어댑터http모듈 (HTTP 클라이언트) → TMDB API