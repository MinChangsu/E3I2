package com.ppiyong.e312.admin.controller;


import com.ppiyong.e312.member.model.UserDto;
import com.ppiyong.e312.member.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class AdminController {

    private final UserService userService;


    @GetMapping("/admin/main.do")
    public String main(){
        return "admin/main";
    }


    @GetMapping("/user")
    public UserDto parseUser(@RequestParam String id) {

        int id_=Integer.parseInt(id);

        UserDto user = userService.getUser(id_);

        return user;

    }



}
