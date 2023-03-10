package com.ppiyong.e312.entity;

import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
@Entity
@Data
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String content;

    private int hit;
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    private String category;

    @CreationTimestamp
    private Timestamp create_at;

}
