package com.ppiyong.e312.admin;


import com.ppiyong.e312.member.entity.User;
import com.ppiyong.e312.member.model.UserDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface MemberService extends UserDetailsService {


    /**
     *  회원 목록 리턴
     */

    List<User> list();

    /**
     * 회원 상세정보
     */

    UserDto detail(int id);


    ResponseEntity delete(int id);

    /**
     *  회원 상태변경
     */

    boolean updateStatus(int id, String userStatus);

    /**
     * 페이징처리
     */
    Page<User> paging(Pageable pageable);

    /**
     *  검색
     */
    Page<User> SearchList(String searchKeyword, Pageable pageable);



    List<UserDto> findAll();

}
