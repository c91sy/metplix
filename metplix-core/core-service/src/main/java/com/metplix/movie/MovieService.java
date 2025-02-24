package com.metplix.movie;

import com.metplix.movie.response.MovieRespons;
import com.metplix.movie.response.PageableMoviesResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MovieService implements FetchMovieUseCase {
    private  final TmdbMoviePort tmdbMoviePort;


    @Override
    public PageableMoviesResponse fetchFromClient(int page) {
         TmdbPageableMovies tmdbPageableMovies = tmdbMoviePort.fetchPageable(page);
        return new PageableMoviesResponse(
                tmdbPageableMovies.getTmdbMovies().stream().map(movie -> new MovieRespons(
                        movie.getMovieName(),
                        movie.getIsAdult(),
                        movie.getGenre(),
                        movie.getOverview(),
                        movie.getReleaseAt()
                )).collect(Collectors.toList()),
                tmdbPageableMovies.getPage(),
                tmdbPageableMovies.isHasNextPage(),
                tmdbPageableMovies.isHasPreviousPage()

        );
    }
}
//유스케이스 코어 모듈에 있는 FatchMovieUseCase
// 내부 비즈니스 로직과 UI 응답 형식을 분리하여 유지보수를 쉽게 하기 위해
// 여러 데이터를 조합하여 최적화된 응답을 생성할 수 있도록 하기 위해