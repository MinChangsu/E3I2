package com.ppiyong.e312.member.service;

import com.ppiyong.e312.auth.PrincipalDetails;
import com.ppiyong.e312.member.entity.User;
import com.ppiyong.e312.member.model.UserDto;
import com.ppiyong.e312.member.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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


    public User getUser() {
        PrincipalDetails principalDetails = (PrincipalDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = principalDetails.getUser();
        return user;

    }
}
