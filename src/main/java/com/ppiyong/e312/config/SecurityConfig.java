package com.ppiyong.e312.config;

import com.ppiyong.e312.jwt.JwtRequestFilter;
import com.ppiyong.e312.member.repository.UserRepository;
import com.ppiyong.e312.auth.OAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
public class SecurityConfig {
    @Autowired
    private OAuthService oAuthService;
    @Autowired
    private CorsConfig corsConfig;
    @Autowired
    private OAuth2AuthenticationSuccessHandler oAuth2AuthenticationSuccessHandler;
    @Autowired
    private UserRepository userRepository;


    @Bean
    SecurityFilterChain filterChain(HttpSecurity http, AuthenticationManager authenticationManager) throws Exception {

        http

                .authorizeRequests()
                .antMatchers("/", "/hello")
                .permitAll()
                .antMatchers("/user")
                .hasAuthority("USER")
                .anyRequest()
                .authenticated()
                .and()
                .addFilter(new JwtRequestFilter(authenticationManager, userRepository))
                .addFilter(corsConfig.corsFilter())
                .csrf().disable()
                .httpBasic().disable()
                .formLogin().disable()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .oauth2Login() // OAuth2 로그인 설정 시작점
//                .loginPage("http://localhost:3000")
                .userInfoEndpoint() // OAuth2 로그인 성공 이후 사용자 정보를 가져올 때 설정 담당
                .userService(oAuthService)
                .and()
                .successHandler(oAuth2AuthenticationSuccessHandler); // JWT authentication token을 만들고, client가 정의한 redirect로 token을 갖고 넘어감
        // OAuth2 로그인 성공 시, 후작업을 진행할 UserService 인터페이스 구현체 등록
        return http.build();
    }


}