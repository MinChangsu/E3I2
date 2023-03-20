package com.ppiyong.e312.admin.repository;


import com.ppiyong.e312.member.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<User,Integer> {

    List<User> findAll();

}
