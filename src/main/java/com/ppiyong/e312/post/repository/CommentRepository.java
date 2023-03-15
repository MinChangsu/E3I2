package com.ppiyong.e312.post.repository;

import com.ppiyong.e312.post.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment,Integer> {
}
