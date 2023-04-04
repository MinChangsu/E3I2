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
public class User implements UserState {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String username;
    private String password;
    private String email;
    private Role role;
    private String userStatus;

    @CreationTimestamp
    private Timestamp create_at;

//    추가 컬럼
    long totalCount;
    long seq;


    @Builder
    public User(int id, String name, String username ,String password, Role role, String email, Timestamp create_at, String userStatus) {
        this.id = id;
        this.name = name;
        this.username =username;
        this.password = password;
        this.role = role;
        this.email = email;
        this.create_at = create_at;
        this.userStatus = userStatus;

    }

    public User() {

    }

    public User(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public User(int id, String name, String username, String email, Timestamp createAt, String userStatus) {
        this.id = id;
        this.name = name;
        this.username =username;
        this.email = email;
        this.create_at = createAt;
        this.userStatus = userStatus;
    }
}

