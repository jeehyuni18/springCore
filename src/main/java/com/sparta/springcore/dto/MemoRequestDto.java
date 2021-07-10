package com.sparta.springcore.dto;

import lombok.Getter;


@Getter
public class MemoRequestDto extends SignupRequestDto {
    private Long id;
    private String title;
    private String contents;



}
