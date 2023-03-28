package com.ppiyong.e312.post.model;

import com.ppiyong.e312.post.entity.Comment;
import lombok.Data;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
public class CommentResponseDto {

private int id;
private String content;
private String createdDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm"));
private String modifiedDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm"));
private String nickname;
private int postsId;

/* Entity -> Dto*/
public CommentResponseDto(Comment comment) {
this.id = comment.getId();
this.content = comment.getContent();
this.createdDate = comment.getCreatedDate();
this.modifiedDate = comment.getModifiedDate();
this.nickname = comment.getUser().getName();
this.postsId = comment.getPost().getId();
}
}