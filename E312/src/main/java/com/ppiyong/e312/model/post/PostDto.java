package com.ppiyong.e312.model.post;

import com.ppiyong.e312.entity.Post;
import com.ppiyong.e312.entity.User;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
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
