package com.ppiyong.e312.member.controller;

import com.ppiyong.e312.member.model.UserDto;
import com.ppiyong.e312.member.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {
private final UserService userService;


    @GetMapping("/user")
    public UserDto userController(@RequestParam String id) {

          int id_=Integer.parseInt(id);


        return userService.getUser(id_);

    }
    @GetMapping("/user1")
    public String userController() {


        return "user";
    }
    @GetMapping("/hello")
    public String hello(){

        return "hello";
    }


}


