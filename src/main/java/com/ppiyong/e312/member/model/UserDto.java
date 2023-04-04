package com.ppiyong.e312.member.model;

import com.ppiyong.e312.member.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class UserDto {
    private int id;
    private String name;
    private String username;
    private String email;
    private String userStatus;

    private Timestamp create_at;

    public UserDto(User user) {
        this.id = user.getId();
        this.name=user.getName();
        this.username=user.getUsername();
        this.email=user.getEmail();
//        this.userStatus= String.valueOf(user.getRole());
        this.create_at=user.getCreate_at();
    }

    public static UserDto of(User member) {
        return UserDto.builder()
                .id(member.getId())
                .name(member.getName())
                .username(member.getUsername())
                .email(member.getEmail())
//                .userStatus(member.getRole())
                .create_at(member.getCreate_at())
                .userStatus(member.getUserStatus())
                .build();
    }

    public UserDto(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }
}
