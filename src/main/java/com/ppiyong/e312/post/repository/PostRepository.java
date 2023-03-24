package com.ppiyong.e312.post.repository;

import com.ppiyong.e312.member.entity.User;
import com.ppiyong.e312.post.entity.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PostRepository extends JpaRepository<Post,Integer> {
Page<Post> findAllByTitleContainingAndCategory(Pageable pageable,String title,String category);
List<Post> findAllByTitleContainingAndCategoryOrderByIdDesc(String title, String categoey);

List<Post> findAll();

}
