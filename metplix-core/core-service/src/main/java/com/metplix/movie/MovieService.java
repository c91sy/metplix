package com.metplix.movie;

import com.metplix.movie.response.MovieRespons;
import com.metplix.movie.response.PageableMoviesResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor // final 필드에 대한 생성자 자동 생성
public class MovieService implements FetchMovieUseCase{
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

// MovieRespons 객체를 리스트로 수집하여 PageableMoviesResponse에 전달합니다. 이 방법을 통해 영화 목록을 간편하게 변환

/*
TmdbMoviePort 인터페이스는 MovieService 클래스에서 주입받아 사용하는 의존성일 뿐,
클래스 옆에 명시적으로 implements 키워드를 사용하여 구현할 필요는 없다
*/