package com.ppiyong.e312.auth.controller;

import com.ppiyong.e312.auth.*;
import com.ppiyong.e312.config.OAuth2AuthenticationSuccessHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequiredArgsConstructor
public class AuthController {
    private final KaKaoLogin kaKaoLogin;
    private final OAuthService oAuthService;

    private final OAuth2AuthenticationSuccessHandler oAuth2AuthenticationSuccessHandler;
    @GetMapping("/aaa")
    public String login(@RequestParam String code, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("code = " + code);
        AuthorizationKakao authorizationKakao =kaKaoLogin.callTokenApi(code);
        System.out.println("authorizationKakao = " + authorizationKakao);
        KakaoUserInfo kakaoUserInfo =kaKaoLogin.callGetUserByAccessToken(authorizationKakao.getAccess_token());
        System.out.println("kakaoUserInfo = " + kakaoUserInfo);
       PrincipalDetails principalDetails= oAuthService.loadUserKaKao(kakaoUserInfo);

        Authentication authentication = new UsernamePasswordAuthenticationToken(principalDetails, // 나중에 컨트롤러에서 DI해서
                // 쓸 때 사용하기 편함.
                null, // 패스워드는 모르니까 null 처리, 어차피 지금 인증하는게 아니니까!!
                principalDetails.getAuthorities());

        oAuth2AuthenticationSuccessHandler.onAuthenticationSuccess2(request,response,authentication);
        return "성공";

    }
}
