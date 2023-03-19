package com.ppiyong.e312.admin.mapper;


import com.ppiyong.e312.admin.dto.MemberDto;
import com.ppiyong.e312.admin.model.MemberParam;
import com.ppiyong.e312.member.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MemberMapper {

    List<MemberDto> selectList(MemberParam parameter);

}
