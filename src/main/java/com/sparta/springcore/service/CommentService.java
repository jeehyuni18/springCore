package com.sparta.springcore.service;


import com.sparta.springcore.dto.CommentRequestDto;
import com.sparta.springcore.dto.MemoRequestDto;
import com.sparta.springcore.model.Comment;
import com.sparta.springcore.model.Memo;
import com.sparta.springcore.repository.CommentRepository;
import com.sparta.springcore.repository.MemoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class CommentService {
    private final CommentRepository commentRepository;

    @Transactional
    public Long update_comment(Long id, CommentRequestDto commentRequestDto){
        Comment comment = commentRepository.findById(id).orElseThrow(
                ()-> new IllegalArgumentException("해당 아이디가 없습니다.")
        );
        comment.update_comment(commentRequestDto);
        return comment.getId();

    }
}

