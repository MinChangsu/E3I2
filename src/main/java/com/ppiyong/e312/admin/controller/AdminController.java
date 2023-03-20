package com.ppiyong.e312.admin.controller;


import com.ppiyong.e312.admin.MemberService;
import com.ppiyong.e312.admin.dto.MemberDto;
import com.ppiyong.e312.admin.model.Role;
import com.ppiyong.e312.auth.PrincipalDetails;
import com.ppiyong.e312.member.model.UserDto;
import com.ppiyong.e312.member.service.UserService;
import com.ppiyong.e312.post.model.PostResponseDto;
import com.ppiyong.e312.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class AdminController {

    private final UserService userService;
    private final MemberService memberService;
    private final PostService postService;


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

    @Transactional
    @GetMapping("/admin/postList")
    public List<PostResponseDto> postList(
            @RequestParam(required=false,defaultValue="")
            String title){

        return postService.getPostAll(title);
    }

    @PutMapping("/admin/roleupdate")
    public ResponseEntity RoleUpdate(@RequestBody Role role){
//        Authentication authentication=SecurityContextHolder.getContext().getAuthentication();
//        PrincipalDetails principalDetails=(PrincipalDetails) authentication.getPrincipal();
//        User user=principalDetails.getUser();
//        int id=user.getId();

        PrincipalDetails principalDetails=(PrincipalDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        int id=principalDetails.getUser().getId();

        return memberService.update(id, role);
    }

    @DeleteMapping("/admin/post")
    public ResponseEntity memberDelete(){
        PrincipalDetails principalDetails=(PrincipalDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        int id=principalDetails.getUser().getId();

        return memberService.delete(id);
    }






}
