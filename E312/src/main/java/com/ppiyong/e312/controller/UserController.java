package com.ppiyong.e312.controller;

import com.ppiyong.e312.entity.User;
import com.ppiyong.e312.model.user.UserDto;
import com.ppiyong.e312.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
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


