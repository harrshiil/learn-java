package com.sfl.security.jwtsecurity.controller;

import com.sfl.security.jwtsecurity.model.JwtUser;
import com.sfl.security.jwtsecurity.security.JwtGenerater;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/token")
public class TokenController {

    @Autowired
    private JwtGenerater jwtGenerater;

    public TokenController(JwtGenerater jwtGenerater) {
        this.jwtGenerater = jwtGenerater;
    }

    @PostMapping
    public String generateToken(@RequestBody final JwtUser jwtUser) {
        return jwtGenerater.generate(jwtUser);
    }

}
