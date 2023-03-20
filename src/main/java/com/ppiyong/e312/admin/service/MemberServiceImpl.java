package com.ppiyong.e312.admin.service;

import com.ppiyong.e312.admin.MemberService;
import com.ppiyong.e312.admin.dto.MemberDto;
import com.ppiyong.e312.admin.mapper.MemberMapper;
import com.ppiyong.e312.admin.model.MemberParam;
import com.ppiyong.e312.admin.repository.MemberRepository;
import com.ppiyong.e312.member.entity.User;
import com.ppiyong.e312.post.entity.Post;
import com.ppiyong.e312.post.model.PostResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;
    private final MemberMapper memberMapper;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;

    }

//  mapper에서 사용
    @Override
    public List<MemberDto> list(MemberParam parameter) {

        long totalCount = memberMapper.selectListCount(parameter);

        List<MemberDto> list = memberMapper.selectList(parameter);

        if(!CollectionUtils.isEmpty(list)){
            int i = 0;
            for(MemberDto x : list){
                x.setTotalCount(totalCount);
                x.setSeq(totalCount - parameter.getPageStart() - i );
                i++;
            }
        }
        return list;
    }


    @Override
    public List<MemberDto> memberList() {

        List<User> list = memberRepository.findAll();
        List<MemberDto> memberList = new ArrayList<>();

        for (User u : list) {
            memberList.add(new MemberDto(u));
        }

        return memberList;
    }


    @Override
    public MemberDto getUser(int id) {

            Optional<User> user = memberRepository.findById(id);

            if (user.isPresent()) {

                return new MemberDto(user.get());
            } else {
                return null;
            }
        }
    }

