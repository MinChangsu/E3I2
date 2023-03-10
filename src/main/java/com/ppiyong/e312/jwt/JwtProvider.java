package com.ppiyong.e312.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.ppiyong.e312.entity.User;
import org.springframework.stereotype.Component;

import java.util.Date;
@Component
public class JwtProvider {
    public String createToken(User user) { //(2-1)

        //(2-2)
        String jwtToken = JWT.create()

                //(2-3)
                .withSubject(user.getEmail())
                .withExpiresAt(new Date(System.currentTimeMillis() + JwtProperties.EXPIRATION_TIME))

                //(2-4)
                .withClaim("username", user.getUsername())
                .withClaim("id", user.getId())

                //(2-5)
                .sign(Algorithm.HMAC512(JwtProperties.SECRET));

        return jwtToken; //(2-6)
    }
}
