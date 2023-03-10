package com.ppiyong.e312.model.user;

import com.ppiyong.e312.entity.User;
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
    @CreationTimestamp
    private Timestamp create_at;

    public UserDto(User user) {
        this.id = user.getId();
        this.name=user.getName();
        this.username=user.getUsername();
        this.email=user.getEmail();
        this.role=user.getRole();
        this.create_at=user.getCreate_at();
    }
}
