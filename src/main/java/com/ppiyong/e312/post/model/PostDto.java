package com.ppiyong.e312.post.model;

import com.ppiyong.e312.post.entity.Post;
import lombok.Data;

import java.sql.Timestamp;
@Data
public class PostDto {
    private int id;
    private String title;
    private String content;

    private int hit;

    private String writer;

    private String category;


    private Timestamp create_at;


    public PostDto(Post post) {
        this.id = post.getId();
        this.title = post.getTitle();
        this.content = post.getContent();
        this.hit = post.getHit();
        this.writer = post.getUser().getName();
        this.category = post.getCategory();
        this.create_at = post.getCreate_at();
    }
}
