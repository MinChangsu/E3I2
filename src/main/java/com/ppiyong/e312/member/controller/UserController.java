package com.ppiyong.e312.member.controller;


import com.ppiyong.e312.admin.model.Role;
import com.ppiyong.e312.member.entity.User;
import com.ppiyong.e312.member.model.UserDto;
import com.ppiyong.e312.member.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {
private final UserService userService;


    @PutMapping("/user")
    public UserDto userController(@RequestParam int id,@RequestParam int role) {

         UserDto user = userService.role(id,role);
        return user;
    }
    @DeleteMapping("/user")
    public ResponseEntity deleteuser(@RequestParam int id){
        userService.deleteUser(id);
        return ResponseEntity.ok("유저 삭제");
    }


    @GetMapping("/getuser")
    public UserDto userRole(){

        return userService.getUser();
    }

    @GetMapping("/hello")
    public String hello(){

        return "hello";
    }
    @GetMapping("/userlist")
    public List<UserDto> userlist(){

        return userService.getList();
    }


}


