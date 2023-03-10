package com.ppiyong.e312.service;

import com.ppiyong.e312.auth.PrincipalDetails;
import com.ppiyong.e312.entity.Post;
import com.ppiyong.e312.entity.User;
import com.ppiyong.e312.model.post.PostDto;
import com.ppiyong.e312.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    public List<Post> getPostAll() {

        return null;
    }

    public Post createPost(Post post) {


        PrincipalDetails principalDetails = (PrincipalDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = principalDetails.getUser();
        System.out.println("user = " + user);
        post.setUser(user);
        postRepository.save(post);


        return post;
    }
    @Transactional
    public PostDto getPost(int num) {
        Optional<Post> postbox = postRepository.findById(num);
        if (postbox.isPresent()) {

            Post post = postbox.get();
            PostDto postDto = new PostDto(post);
            return postDto;

        } else return null;
    }

    public List<PostDto> getPostAll(Pageable pageable,String title) {


        Page<Post> list = postRepository.findAllByTitleContaining(pageable,title);
        List<PostDto> list_ = new ArrayList<>();

        for (Post p : list) {
            list_.add(new PostDto(p));
        }
        System.out.println("list = " + list_);
        return list_;
    }

}
