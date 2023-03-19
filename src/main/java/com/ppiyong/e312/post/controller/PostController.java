package com.ppiyong.e312.post.controller;

import com.ppiyong.e312.post.entity.Post;
import com.ppiyong.e312.post.model.PostDto;
import com.ppiyong.e312.post.model.PostResponseDto;
import com.ppiyong.e312.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    @PostMapping("/post")
    public PostResponseDto createPost(@RequestBody Post post){

        return postService.createPost(post);
    }
    @Transactional
    @GetMapping("/post")
    public PostResponseDto post(@RequestParam int id){

        return postService.getPost(id);
    }
    @Transactional
    @GetMapping("/pagePostAll")
    public List<PostResponseDto> postAll(
            @PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.DESC)
            Pageable pageable,
            @RequestParam(required=false,defaultValue="")
            String title){

        return postService.getPostAll(pageable,title);
    }
    @Transactional
    @GetMapping("/postAll")
    public List<PostResponseDto> postAll(
            @RequestParam(required=false,defaultValue="")
            String title){

        return postService.getPostAll(title);
    }
    @Transactional
    @GetMapping("/pageReport-postAll")
    public List<PostResponseDto> reportpostAll(
            @PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.DESC)
            Pageable pageable,
            @RequestParam(required=false,defaultValue="")
            String title){

        return postService.getReportPostAll(pageable,title);
    }
    @Transactional
    @GetMapping("/report-postAll")
    public List<PostResponseDto> reportpostAll(
            @RequestParam(required=false,defaultValue="")
            String title){

        return postService.getReportPostAll(title);
    }
    @PutMapping("/post")
    public ResponseEntity postUpdate(@RequestParam int id, @RequestBody PostResponseDto postResponseDto){
        return postService.update(id,postResponseDto);
    }
    @DeleteMapping("/post")
    public ResponseEntity postDelete(@RequestParam int id){


        return postService.delete(id);
    }
}
