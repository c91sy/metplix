package com.metplix.sample;

import lombok.Getter;

@Getter
public class Sample {
    private  final  String name;

    private  Sample(String name){
        this.name = name;
    }
}
