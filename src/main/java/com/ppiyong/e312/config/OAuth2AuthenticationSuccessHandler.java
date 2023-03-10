package com.ppiyong.e312.config;

import com.ppiyong.e312.auth.PrincipalDetails;
import com.ppiyong.e312.member.entity.User;
import com.ppiyong.e312.jwt.JwtProperties;
import com.ppiyong.e312.jwt.JwtProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@Component
@RequiredArgsConstructor
public class OAuth2AuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    private final JwtProvider jwtProvider;
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        PrincipalDetails pr= (PrincipalDetails) authentication.getPrincipal();
        User user=pr.getUser();
        String jwtToken=jwtProvider.createToken(user);
        response.setHeader(JwtProperties.HEADER_STRING, JwtProperties.TOKEN_PREFIX + jwtToken);

      response.sendRedirect("http://localhost:3000");
    }
}
