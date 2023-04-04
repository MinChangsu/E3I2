package com.ppiyong.e312.admin.dto;

import com.ppiyong.e312.admin.model.Role;
import lombok.Data;

import java.sql.Timestamp;

@Data
public class MemberDto {

        private int id;
        private String name;
        private String username;
        private String email;
        private String role;

        private Timestamp create_at;

        long totalCount;
        long seq;


//        public MemberDto(User user) {
//                this.id = user.getId();
//                this.name=user.getName();
//                this.username=user.getUsername();
//                this.email=user.getEmail();
//                this.role= String.valueOf(user.getRole());
//                this.create_at=user.getCreate_at();
//        }

    public void update(Role role) {
        this.role = String.valueOf(role);

    }



}
