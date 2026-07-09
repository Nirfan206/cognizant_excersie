package org.example.controller;

//import com.example.jwt.util.JwtUtil;
import org.example.util.JwtUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

@RestController
public class AuthenticationController {

    @GetMapping("/authenticate")
    public Map<String, String> authenticate(
            @RequestHeader("Authorization")
            String authorizationHeader) {

        String base64Credentials =
                authorizationHeader.substring(6);

        byte[] decodedBytes =
                Base64.getDecoder()
                        .decode(base64Credentials);

        String credentials =
                new String(decodedBytes,
                        StandardCharsets.UTF_8);

        String[] values =
                credentials.split(":");

        String username = values[0];

        String password = values[1];

        // Normally password is checked with database

        String token =
                JwtUtil.generateToken(username);

        Map<String, String> map =
                new HashMap<>();

        map.put("token", token);

        return map;

    }

}