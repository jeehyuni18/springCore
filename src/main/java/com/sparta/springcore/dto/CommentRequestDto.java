package com.sparta.springcore.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CommentRequestDto {
    private Long memo_id;
    private String username;
    private String contents;
}
