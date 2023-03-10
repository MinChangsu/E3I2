package com.ppiyong.e312.post.repository;

import com.ppiyong.e312.post.entity.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post,Integer> {
Page<Post> findAllByTitleContaining(Pageable pageable,String title);


}
