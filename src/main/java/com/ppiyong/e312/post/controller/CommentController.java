package com.ppiyong.e312.post.controller;

import com.ppiyong.e312.post.model.CommentRequestDto;
import com.ppiyong.e312.post.model.CommentResponseDto;
import com.ppiyong.e312.post.repository.CommentRepository;
import com.ppiyong.e312.post.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;
    @PostMapping("/comment")
    public CommentResponseDto createComment(@RequestParam int post_id, @RequestBody CommentRequestDto commentRequestDto){
        return commentService.createComment(commentRequestDto,post_id);


    }
}
