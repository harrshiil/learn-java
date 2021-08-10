package com.learn.microservice.securityzero.resource;


import com.learn.microservice.securityzero.authorization.TokenBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class LoginResource
{
    @Autowired
    private TokenBuilder tokenBuilder;

    @PostMapping("/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password)
    {
        String role = "ROLE_USER";

        return tokenBuilder.jwtAuthToken(username,role);
    }
}
