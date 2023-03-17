package com.ppiyong.e312.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class CorsConfig {

   @Bean
   public CorsFilter corsFilter() {
      UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
      CorsConfiguration config = new CorsConfiguration();
      config.setAllowCredentials(true); // 내 서버가 응답할 때 json을 자바스크립트에서 처리할 수 있게 할지 설정하는것
      config.addAllowedOriginPattern("*");// Access-Control-Allow-Origin  (Response에 자동으로 추가해줌) 모든 ip 응답허용
      config.addAllowedHeader("*");  // Access-Control-Request-Headers 모든 header에 응답허용
      config.addAllowedMethod("*"); // Access-Control-Request-Method   모든 post,get,put,delete,patch 요청 허용
      config.addExposedHeader("Authorization");
      
      source.registerCorsConfiguration("/**", config);
      return new CorsFilter(source);
   }

}
