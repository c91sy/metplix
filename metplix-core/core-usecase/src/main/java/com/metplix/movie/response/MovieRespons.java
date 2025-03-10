package com.metplix.movie.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor // final 필드에 대한 생성자 자동 생성
public class MovieRespons {
    private  final String movieName;
    private  final Boolean isAdult; //성인여부
    private  final String genre; //장르
    private  final String overview; //설명
    private  final String releaseAt; //출시일자
}
