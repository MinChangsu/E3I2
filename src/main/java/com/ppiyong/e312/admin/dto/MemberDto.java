package com.ppiyong.e312.admin.dto;

import com.ppiyong.e312.member.entity.User;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Timestamp;

@Data
public class MemberDto {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int userId;

        private String name;
        private String userName;
        private String email;
        private String role;
        @CreationTimestamp
        private Timestamp create_at;

        boolean adminYn;

        // 추가컬럼
        long totalCount;
        long seq;

        public MemberDto(User user) {
            this.userId = user.getId();
            this.name=user.getName();
            this.userName=user.getUsername();
            this.email=user.getEmail();
            this.role=user.getRole();
            this.create_at=user.getCreate_at();
        }






}
