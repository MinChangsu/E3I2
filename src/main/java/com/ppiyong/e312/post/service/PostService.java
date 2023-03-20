package com.ppiyong.e312.post.service;

import com.ppiyong.e312.auth.PrincipalDetails;
import com.ppiyong.e312.post.entity.Post;
import com.ppiyong.e312.member.entity.User;
import com.ppiyong.e312.post.model.PostDto;
import com.ppiyong.e312.post.model.PostResponseDto;
import com.ppiyong.e312.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;


    public PostResponseDto createPost(Post post) {

        PrincipalDetails principalDetails = (PrincipalDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = principalDetails.getUser();
        System.out.println("user = " + user);
        post.setUser(user);
        postRepository.save(post);
        PostResponseDto postdto=new PostResponseDto(post);

        return postdto;
    }

    @Transactional
    public PostResponseDto getPost(int id) {
        Optional<Post> postbox = postRepository.findById(id);
        if (postbox.isPresent()) {

            Post post = postbox.get();
            int hit = post.getHit();
            post.setHit(hit + 1);
            PostResponseDto postDto = new PostResponseDto(post);
            postRepository.save(post);

            return postDto;

        } else return null;
    }

    public List<PostResponseDto> getPostAll(Pageable pageable, String title) {


        Page<Post> list = postRepository.findAllByTitleContainingAndCategory(pageable, title,"자유게시판");
        List<PostResponseDto> list_ = new ArrayList<>();

        for (Post p : list) {
            list_.add(new PostResponseDto(p));
        }

        return list_;
    }
    public List<PostResponseDto> getPostAll(String title) {


        List<Post> list = postRepository.findAllByTitleContainingAndCategory(title,"자유게시판");
        List<PostResponseDto> list_ = new ArrayList<>();

        for (Post p : list) {
            list_.add(new PostResponseDto(p));
        }

        return list_;
    }
    public List<PostResponseDto> getReportPostAll(Pageable pageable, String title) {
        Page<Post> list = postRepository.findAllByTitleContainingAndCategory(pageable, title,"신고게시판");
        List<PostResponseDto> list_ = new ArrayList<>();

        for (Post p : list) {
            list_.add(new PostResponseDto(p));
        }

        return list_;
    }
    public List<PostResponseDto> getReportPostAll(String title) {
        List<Post> list = postRepository.findAllByTitleContainingAndCategory( title,"신고게시판");
        List<PostResponseDto> list_ = new ArrayList<>();

        for (Post p : list) {
            list_.add(new PostResponseDto(p));
        }

        return list_;
    }

    public ResponseEntity update(int id, PostResponseDto postResponseDto) {
        Post post=postRepository.findById(id).get();
        post.update(postResponseDto.getTitle(),postResponseDto.getContent());
        postRepository.save(post);
        return ResponseEntity.ok(null);
    }

    public ResponseEntity delete(int id) {
        postRepository.deleteById(id);
        return ResponseEntity.ok("good");
    }


}
