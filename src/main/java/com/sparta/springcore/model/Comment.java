package com.sparta.springcore.model;

import com.sparta.springcore.dto.CommentRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@NoArgsConstructor // 기본생성자를 만듭니다.
@Getter
@Entity // 테이블과 연계됨을 스프링에게 알려줍니다.
public class Comment extends Timestamped{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private Long memo_id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String contents;

    public Comment (CommentRequestDto commentRequestDto){
        this.memo_id = commentRequestDto.getMemo_id();
        this.username = commentRequestDto.getUsername();
        this.contents = commentRequestDto.getContents();
    }

    public void update_comment(CommentRequestDto commentRequestDto){
        this.memo_id = commentRequestDto.getMemo_id();
        this.username = commentRequestDto.getUsername();
        this.contents = commentRequestDto.getContents();
    }

}