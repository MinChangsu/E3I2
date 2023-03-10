package com.ppiyong.e312.service;

import com.ppiyong.e312.entity.User;
import com.ppiyong.e312.model.user.UserDto;
import com.ppiyong.e312.repository.UserRepository;
import lombok.RequiredArgsConstructor;
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


}
