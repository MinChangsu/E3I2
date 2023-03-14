package com.ppiyong.e312.post.model;

import com.ppiyong.e312.post.entity.Comment;
import com.ppiyong.e312.post.entity.Post;
import lombok.Data;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class PostResponseDto {

private int id;
private String title;
private String writer;
private String content;
private String createdDate, modifiedDate;
private int hit;
private int userId;
private List<CommentResponseDto> comments;

/* Entity -> Dto*/
        public PostResponseDto(Post post) {
this.id = post.getId();
this.title = post.getTitle();
this.writer = post.getUser().getName();
this.content = post.getContent();
this.createdDate = post.getCreatedDate().format(DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm"));;
this.modifiedDate = post.getModifiedDate().format(DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm"));;
this.hit = post.getHit();
this.userId = post.getUser().getId();
this.comments = post.getComments()==null?new ArrayList<CommentResponseDto>():post.getComments().stream().map(CommentResponseDto::new).collect(Collectors.toList());
}
}
