package com.ppiyong.e312.post.controller;

import com.ppiyong.e312.post.entity.Comment;
import com.ppiyong.e312.post.model.CommentRequestDto;
import com.ppiyong.e312.post.model.CommentResponseDto;
import com.ppiyong.e312.post.repository.CommentRepository;
import com.ppiyong.e312.post.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;
    @PostMapping("/comment")
    public CommentResponseDto createComment(@RequestParam int post_id, @RequestBody CommentRequestDto commentRequestDto){
        return commentService.createComment(commentRequestDto,post_id);


    }
    @DeleteMapping("/comment")
    public  ResponseEntity deleteComment(@RequestParam int id){
        return commentService.delete(id);
    }
    @Transactional
    @PutMapping("/comment")
    public ResponseEntity updateComment(@RequestParam int id,@RequestBody CommentRequestDto commentRequestDto){
        System.out.println("commentRequestDto = " + commentRequestDto);
        return commentService.update(id,commentRequestDto);
    }
}
