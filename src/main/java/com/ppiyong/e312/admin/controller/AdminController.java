package com.ppiyong.e312.admin.controller;


import com.ppiyong.e312.admin.MemberService;
import com.ppiyong.e312.admin.dto.MemberDto;
import com.ppiyong.e312.member.model.UserDto;
import com.ppiyong.e312.member.service.UserService;
import com.ppiyong.e312.post.model.PostResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class AdminController {

    private final UserService userService;
    private final MemberService memberService;


    @GetMapping("/admin/main.do")
    public String main(){
        return "admin/main";
    }


    @GetMapping("/admin/user")
    public UserDto parseUser(@RequestParam String id) {

        int id_=Integer.parseInt(id);

        UserDto user = userService.getUser(id_);

        return user;
    }

    @Transactional
    @GetMapping("/admin/memberList")
    public List<MemberDto> memberList(
            @RequestParam(required=false,defaultValue="")
            String id){

        return memberService.memberList();
    }



}
