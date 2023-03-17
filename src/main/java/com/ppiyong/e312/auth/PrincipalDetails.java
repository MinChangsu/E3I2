package com.ppiyong.e312.auth;

import com.ppiyong.e312.member.entity.User;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
@Data
public class PrincipalDetails implements OAuth2User ,UserDetails {
    private final User user;
    private  OAuth2UserInfo oAuth2UserInfo;

//    OAuth 로긴
    public PrincipalDetails(User user,OAuth2UserInfo oAuth2UserInfo) {
        this.user = user;
        this.oAuth2UserInfo=oAuth2UserInfo;
    }

//    일반 로긴
    public PrincipalDetails(User user) {
        this.user = user;
    }

    @Override
    public Map<String, Object> getAttributes() {
        return oAuth2UserInfo.getAttributes();
    }


    // 해당 User 권한을 리턴?
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> collect = new ArrayList<>();
        collect.add((GrantedAuthority) () -> user.getRole());
        return collect;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

//    계정만료되었는지?
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

//    계정 잠겼는지?
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

//    계정비밀번호 기간 지났는지?
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

//    계정 활성화 되었는지?
    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public String getName() {


        return user.getName();
    }

}
