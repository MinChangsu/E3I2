package com.ppiyong.e312.admin.controller;


import com.ppiyong.e312.admin.MemberService;

import com.ppiyong.e312.admin.dto.MemberDto;
import com.ppiyong.e312.admin.model.MemberParam;
import com.ppiyong.e312.admin.model.MemberStatusInput;
import com.ppiyong.e312.admin.repository.MemberRepository;
import com.ppiyong.e312.member.entity.User;
import com.ppiyong.e312.member.model.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.List;

@RequiredArgsConstructor
@Controller
public class AdminMemberController{

    private final MemberService memberService;
    private final MemberRepository memberRepository;

    @GetMapping("/list.do" )
    public String memberList(Model model, @PageableDefault(page = 1) Pageable pageable,
                             String searchKeyword){

        Page<User> memberList = null;

        if(searchKeyword == null){
            memberList = memberService.paging(pageable);
        }else {
            memberList = memberService.SearchList(searchKeyword, pageable);
        }

        List<User> members = memberService.list();
        long totalCount =0;

        if(!CollectionUtils.isEmpty(members)){
            int i = 0;
            for(User x : members){
                totalCount++;
            }
        }
        int blockLimit =5;
        int startPage = (((int)(Math.ceil((double)pageable.getPageNumber() / blockLimit))) - 1) * blockLimit + 1; // 1 4 7 10 ~~
        int endPage = ((startPage + blockLimit - 1) < memberList.getTotalPages()) ? startPage + blockLimit - 1 : memberList.getTotalPages();


        model.addAttribute("totalCount", totalCount);
        model.addAttribute("memberList", memberList);
//        model.addAttribute("memberList2", memberList2);
        model.addAttribute("startPage", startPage);
        model.addAttribute("endPage", endPage);

        return "admin/member/list";

    }

    @GetMapping("/detail.do")
    public String detail(Model model, MemberParam user){

        UserDto member = memberService.detail(user.getId());
        model.addAttribute("member", member);

        return "admin/member/detail";

    }

    @PostMapping("/status.do")
    public String status(Model model, MemberStatusInput parameter){

        boolean result = memberService.updateStatus(parameter.getId(), parameter.getUserStatus());

        return "redirect:/detail.do?id"+ parameter.getId();
    }







}
