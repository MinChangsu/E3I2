package com.ppiyong.e312.post.service;

import com.ppiyong.e312.auth.PrincipalDetails;
import com.ppiyong.e312.member.entity.User;
import com.ppiyong.e312.post.entity.Comment;
import com.ppiyong.e312.post.entity.Post;
import com.ppiyong.e312.post.model.CommentRequestDto;
import com.ppiyong.e312.post.model.CommentResponseDto;
import com.ppiyong.e312.post.repository.CommentRepository;
import com.ppiyong.e312.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
    private final PostRepository postRepository;

    public CommentResponseDto createComment(CommentRequestDto commentRequestDto, int post_id) {
        PrincipalDetails principalDetails = (PrincipalDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = principalDetails.getUser();
        Post post = postRepository.findById(post_id).get();
        commentRequestDto.setPost(post);
        commentRequestDto.setUser(user);
        Comment comment=commentRequestDto.toEntity();
        commentRepository.save(comment);
        CommentResponseDto commentDto=new CommentResponseDto(comment);

        return commentDto;

    }


}

