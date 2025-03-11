package com.metplix.movie;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Getter
@RequiredArgsConstructor // final 필드들을 위한 생성자 자동 생성
public class TmdbMovie {
    private  final String movieName;
    private  final Boolean isAdult; //성인여부
    private  final List<String> genre; //장르
    private  final String overview; //설명
    private  final String releaseAt; //출시일자
}
