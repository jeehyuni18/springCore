package com.sparta.springcore.controller;

import com.sparta.springcore.dto.CommentRequestDto;

import com.sparta.springcore.model.Comment;
import com.sparta.springcore.repository.CommentRepository;
import com.sparta.springcore.service.CommentService;
import com.sparta.springcore.util.CommentSpecs;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class CommentController {

    private final CommentRepository commentRepository;
    private final CommentService commentService;

//    @GetMapping("/api/comments")
//    public List<Comment> getComment(){
//        return commentRepository.findAllByOrderByModifiedAtDesc();
//    }


    @GetMapping("/api/comment/{memo_id}")
    public List<Comment> getComment(@PathVariable Long memo_id){
        return commentRepository.findAll(CommentSpecs.withmemo_id(memo_id));
    }


    @PostMapping("/api/comments")
    public Comment createComment(@RequestBody CommentRequestDto commentRequestDto){
        Comment comment = new Comment(commentRequestDto);
        return commentRepository.save(comment);
    }

    @PutMapping("/api/comments/{id}")
    public Long updateComment(@PathVariable Long id, @RequestBody CommentRequestDto commentRequestDto){
        return commentService.update_comment(id, commentRequestDto);
    }

    @DeleteMapping("/api/comments/{id}")
    public Long deleteComment(@PathVariable Long id){
        commentRepository.deleteById(id);
        return id;
    }
}