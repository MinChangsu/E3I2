package com.ppiyong.e312.admin.service;

import com.ppiyong.e312.admin.MemberService;
import com.ppiyong.e312.admin.repository.MemberRepository;
import com.ppiyong.e312.member.entity.User;
import com.ppiyong.e312.member.model.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;

    }

    @Override
    public List<User> list() {
        return memberRepository.findAll();
    }

    @Override
    public UserDto detail(int id) {
        Optional<User> optionalMember = memberRepository.findById(id);
        if(!optionalMember.isPresent()){
            return null;
        }

        User member = optionalMember.get();

        return UserDto.of(member);
    }


    @Override
    public ResponseEntity delete(int id) {
        memberRepository.deleteById(id);
        return ResponseEntity.ok("멤버 삭제요청 완료");
    }

    @Override
    public boolean updateStatus(int id, String userStatus) {

        Optional<User> optionalMember = memberRepository.findById(id);
        if(!optionalMember.isPresent()){
            throw new UsernameNotFoundException("회원 정보가 존재하지 않습니다.");
        }

        User member = optionalMember.get();

        member.setUserStatus(userStatus);
        memberRepository.save(member);

        return true;
    }

    @Override
    public Page<User> paging(Pageable pageable) {
        int page = pageable.getPageNumber() -1;
        int pageLimit = 10; // 한 페이지에 보여줄 글 갯수
        Page<User> member =
        memberRepository.findAll(PageRequest.of(page, pageLimit, Sort.by(Sort.Direction.DESC,"id")));

        Page<User> users = member.map( user -> new User(user.getId(), user.getName(), user.getUsername(), user.getEmail(), user.getCreate_at(), user.getUserStatus()));

        return users;

    }

    @Override
    public Page<User> SearchList(String searchKeyword, Pageable pageable) {


        return memberRepository.findAllByNameContaining(searchKeyword,pageable);
    }

    @Override
    public List<UserDto> findAll() {

        List<User> userList = memberRepository.findAll();
        List<UserDto> userDtoList = new ArrayList<>();

        for( User u : userList ){
            userDtoList.add(UserDto.of(u));

        }
        return userDtoList;
    }


}






