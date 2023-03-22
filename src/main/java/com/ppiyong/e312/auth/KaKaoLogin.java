package com.ppiyong.e312.auth;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class KaKaoLogin {
    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

    private final String kakaoOauth2ClinetId = "781439d4c65490bbf7fa59a3bee09329";
    private final String frontendRedirectUrl = "http://localhost:3000/kakaologin";


    public AuthorizationKakao callTokenApi(String code) {
        String grantType = "authorization_code";
        System.out.println("콜토큰 진입" );
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("grant_type", grantType);
        params.add("client_id", kakaoOauth2ClinetId);
        params.add("redirect_uri", frontendRedirectUrl);
        params.add("code", code);

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(params, headers);

        String url = "https://kauth.kakao.com/oauth/token";
        try {
            ResponseEntity<String> response = restTemplate.postForEntity(url, request, String.class);

            AuthorizationKakao authorization = objectMapper.readValue(response.getBody(), AuthorizationKakao.class);

            return authorization;
        } catch (RestClientException | JsonProcessingException ex) {
            ex.printStackTrace();
             return null;

        }
    }


    /**
     * accessToken 을 이용한 유저정보 받기
     * @return
     */
    public KakaoUserInfo callGetUserByAccessToken(String accessToken) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + accessToken);
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(params, headers);

        String url = "https://kapi.kakao.com/v2/user/me";
        try {
            ResponseEntity<Map> response = restTemplate.postForEntity(url, request, Map.class);

            // 값 리턴
            return new KakaoUserInfo(response.getBody());
        }catch (RestClientException ex) {
            ex.printStackTrace();
            return null;

        }
    }
}

