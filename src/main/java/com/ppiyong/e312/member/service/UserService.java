package com.ppiyong.e312.member.service;

import com.ppiyong.e312.admin.model.Role;
import com.ppiyong.e312.auth.PrincipalDetails;
import com.ppiyong.e312.member.entity.User;
import com.ppiyong.e312.member.model.UserDto;
import com.ppiyong.e312.member.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    @Transactional
    public UserDto getUser(int id) {
        Optional<User> user = userRepository.findById(id);

        if (user.isPresent()) {


            return new UserDto(user.get());
        } else {
            return null;
        }
    }



    public UserDto getUser() {

        PrincipalDetails principalDetails = (PrincipalDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = principalDetails.getUser();

        return new UserDto(user);

    }


    public UserDto role(int id, int role) {
        User user=null;
        Role r=null;
        Optional<User> userbox=userRepository.findById(id);
        if(userbox.isPresent()){
            user=userbox.get();
            if (role==0){
                r=Role.ADMIN;
            } else if (role==1) {
                r=Role.USER;

            }
            else {r=Role.POLICE;}
        }
        user.setRole(r);
        user=userRepository.save(user);
        return new UserDto(user);
    }

    public void deleteUser(int id) {
        Optional<User> userbox=userRepository.findById(id);
        User user=null;
        if(userbox.isPresent()){
            user=userbox.get();
        }
        userRepository.delete(user);
    }

    public List<UserDto> getList() {
        List<User> userlist=userRepository.findAll();
        List<UserDto> userList=new ArrayList<>();
        for(User u:userlist){
            userList.add(new UserDto(u));
        }
        return userList;
    }
}
