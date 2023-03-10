package com.ppiyong.e312.controller;

import com.ppiyong.e312.entity.Post;
import com.ppiyong.e312.model.post.PostDto;
import com.ppiyong.e312.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    @PostMapping("/post")
    public Post createPost(@RequestBody Post post){

        return postService.createPost(post);
    }
    @Transactional
    @GetMapping("/post")
    public PostDto post(@RequestParam int num){

        return postService.getPost(num);
    }
    @Transactional
    @GetMapping("/postAll")
    public List<PostDto> postAll(
            @PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.DESC)
            Pageable pageable,
            @RequestParam(required=false,defaultValue="")
            String title){

        return postService.getPostAll(pageable,title);
    }
}
