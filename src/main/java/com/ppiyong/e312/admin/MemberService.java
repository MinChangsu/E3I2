package com.ppiyong.e312.admin;


import com.ppiyong.e312.admin.dto.MemberDto;
import com.ppiyong.e312.admin.model.MemberParam;
import com.ppiyong.e312.member.entity.User;
import com.ppiyong.e312.member.model.UserDto;
import com.ppiyong.e312.post.entity.Post;
import com.ppiyong.e312.post.model.PostResponseDto;
import org.springframework.security.core.userdetails.UserDetailsService;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

public interface MemberService extends UserDetailsService {

    List<MemberDto> list(MemberParam parameter);

    List<MemberDto> memberList();


    @Transactional
    MemberDto getUser(int id);



}
