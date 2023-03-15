package com.ppiyong.e312.post.model;

import com.ppiyong.e312.member.entity.User;
import com.ppiyong.e312.post.entity.Comment;
import com.ppiyong.e312.post.entity.Post;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CommentRequestDto {
    private int id;
    private String content;
    private String createdDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm"));
    private String modifiedDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm"));
    private User user;
    private Post post;

    /* Dto -> Entity */
    public Comment toEntity() {
        Comment comment = Comment.builder()
                .content(content)
                .createdDate(createdDate)
                .modifiedDate(modifiedDate)
                .user(user)
                .post(post)
                .build();

        return comment;
    }
}
