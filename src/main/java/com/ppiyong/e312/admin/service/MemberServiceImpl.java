package com.ppiyong.e312.admin.service;

import com.ppiyong.e312.admin.MemberService;
import com.ppiyong.e312.admin.dto.MemberDto;
import com.ppiyong.e312.admin.mapper.MemberMapper;
import com.ppiyong.e312.admin.model.MemberParam;
import com.ppiyong.e312.member.entity.User;
import com.ppiyong.e312.member.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class MemberServiceImpl implements MemberService {

    private final UserRepository userRepository;
    private final MemberMapper memberMapper;
    private final User user;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;

    }


//    @Override
//    public List<MemberDto> list() {
//        MemberDto parameter = new MemberDto();
//        List<MemberDto> list = memberMapper.selectList();
//
////        return UserRepository.findAll();
//
//
//        return list;
//    }

    @Override
    public List<MemberDto> list(MemberParam parameter) {
        return null;
    }

    @Override
    public List<MemberDto> list() {
        return null;
    }

    @Override
    public MemberDto getUser(int id) {

            Optional<User> user = userRepository.findById(id);

            if (user.isPresent()) {

                return new MemberDto(user.get());
            } else {
                return null;
            }
        }
    }

