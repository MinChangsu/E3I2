package com.ppiyong.e312.admin.repository;


import com.ppiyong.e312.member.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberRepository extends JpaRepository<User,Integer> {

    List<User> findAll();

    Page<User> findByNameContaining(String name, Pageable pageable);

    Page<User> findAllByNameContaining(String Name, Pageable pageable);


}
