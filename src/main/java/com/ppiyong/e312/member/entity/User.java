package com.ppiyong.e312.member.entity;

import com.ppiyong.e312.admin.model.Role;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Timestamp;
@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String username;
    private String password;
    private String email;
    private Role role;
    @CreationTimestamp
    private Timestamp create_at;

//    추가 컬럼
    long totalCount;
    long seq;


    @Builder
    public User(int id, String name, String username ,String password, Role role, String email, Timestamp create_at) {
        this.id = id;
        this.name = name;
        this.username =username;
        this.password = password;
        this.role =role;
        this.email = email;
        this.create_at = create_at;
    }

    public User() {

    }

    public void update(Role role) {
        this.role = role;

    }
}
