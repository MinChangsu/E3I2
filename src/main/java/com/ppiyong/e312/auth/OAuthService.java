package com.ppiyong.e312.auth;

import com.ppiyong.e312.member.entity.User;
import com.ppiyong.e312.member.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OAuthService extends DefaultOAuth2UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

//    userRequest 데이터 후처리 함수
    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        OAuth2User oAuth2User = super.loadUser(userRequest);
        System.out.println("로드유저실행");

        OAuth2UserInfo oAuth2UserInfo = null;
        String provider = userRequest.getClientRegistration().getRegistrationId();
        if (provider.equals("kakao")) {
            oAuth2UserInfo = new KakaoUserInfo(oAuth2User.getAttributes());
            System.out.println("oAuth2UserInfo = " + oAuth2UserInfo.getAttributes());
        }
        else if(provider.equals("google")){
            oAuth2UserInfo = new GoogleUserInfo(oAuth2User.getAttributes());
        }
        else if(provider.equals("naver")){	//추가
            System.out.println(oAuth2User.getAttributes());
            System.out.println(oAuth2User.getAttributes().get("response"));
           oAuth2UserInfo = new NaverUserInfo((Map) oAuth2User.getAttributes().get("response"));
      }
        
        String providerId = oAuth2UserInfo.getProviderId();
        String username = provider + "_" + providerId;
        String nickname = oAuth2UserInfo.getName();
        String password = bCryptPasswordEncoder.encode("민경서");
        String email = oAuth2UserInfo.getEmail();
        Optional<User> byUsername = userRepository.findByUsername(username);
        User newUser=null;
        if(byUsername.isPresent()){
            return new PrincipalDetails(byUsername.get(),oAuth2UserInfo);
        }
        //DB에 없는 사용자라면 회원가입처리
        if (newUser == null) {
            System.out.println("새로운유저라서 회원가입함");
            newUser = User.builder()
                    .username(username)
                    .email(email)
                    .password(password)
                    .role("USER")
                    .name(nickname)
                    .build();

            userRepository.save(newUser);
        }

        return new PrincipalDetails(newUser, oAuth2UserInfo);
    }
    }

