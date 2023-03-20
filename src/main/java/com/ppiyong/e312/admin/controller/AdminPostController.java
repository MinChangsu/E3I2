package com.ppiyong.e312.admin.controller;


import com.ppiyong.e312.admin.MemberService;
import com.ppiyong.e312.admin.dto.MemberDto;
import com.ppiyong.e312.admin.model.MemberParam;
import com.ppiyong.e312.member.entity.User;
import com.ppiyong.e312.post.entity.Post;
import com.ppiyong.e312.post.model.PostResponseDto;
import com.ppiyong.e312.post.service.PostService;
import com.ppiyong.e312.util.PageUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class AdminPostController {

    private final MemberService memberService;

    @GetMapping("/admin/Post/list.do")
    public String memberList(Model model, MemberParam parameter){

        parameter.init();

       List<MemberDto> members = memberService.list(parameter);

        long totalCount = 0;
        if (members != null && members.size() > 0) {
            totalCount = members.get(0).getTotalCount();
        }

        String queryString = "";

        PageUtil pageUtil = new PageUtil(totalCount, parameter.getPageSize(), parameter.getPageIndex(), queryString);

        model.addAttribute("list", members);
        model.addAttribute("totalCount", totalCount);
        model.addAttribute("pager", pageUtil.pager());

        return "admin/member/list";

    }

}
