package com.ppiyong.e312.member.model;

import com.ppiyong.e312.member.entity.User;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;
@Data
public class UserDto {
    private int id;
    private String name;
    private String username;
    private String email;
    private String role;

    private Timestamp create_at;

    public UserDto(User user) {
        this.id = user.getId();
        this.name=user.getName();
        this.username=user.getUsername();
        this.email=user.getEmail();
        this.role= String.valueOf(user.getRole());
        this.create_at=user.getCreate_at();
    }
}
