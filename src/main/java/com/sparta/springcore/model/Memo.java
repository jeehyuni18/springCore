package com.sparta.springcore.model;

import com.sparta.springcore.dto.MemoRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor // 기본생성자를 만듭니다.
@Getter
@Entity // 테이블과 연계됨을 스프링에게 알려줍니다.
public class Memo extends com.sparta.springcore.model.Timestamped { // 생성,수정 시간을 자동으로 만들어줍니다.
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(nullable = false)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String contents;


    public Memo(Long id, String title, String contents) {
        this.id=id;
        this.title=title;
        this.contents = contents;

    }

    public Memo(MemoRequestDto requestDto) {
        this.id=requestDto.getId();
        this.contents = requestDto.getContents();
        this.title=requestDto.getTitle();

    }

    public void update(MemoRequestDto requestDto) {
        this.id=requestDto.getId();
        this.title=requestDto.getTitle();
        this.contents = requestDto.getContents();

    }
}