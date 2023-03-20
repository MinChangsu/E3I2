package com.ppiyong.e312.admin;


import com.ppiyong.e312.admin.dto.MemberDto;
import com.ppiyong.e312.admin.model.MemberParam;
import com.ppiyong.e312.admin.model.Role;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetailsService;

import javax.transaction.Transactional;
import java.util.List;

public interface MemberService extends UserDetailsService {

    List<MemberDto> list(MemberParam parameter);

    List<MemberDto> memberList();

    @Transactional
    MemberDto getUser(int id);

    ResponseEntity update(int id, Role memberDto);
}
