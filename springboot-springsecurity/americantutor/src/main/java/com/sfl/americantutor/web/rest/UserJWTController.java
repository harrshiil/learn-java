package com.sfl.americantutor.web.rest;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sfl.americantutor.domain.ATAuthority;
import com.sfl.americantutor.domain.ATUser;
import com.sfl.americantutor.repository.AuthorityRepository;
import com.sfl.americantutor.repository.UserRepository;
import com.sfl.americantutor.security.AuthoritiesConstants;
import com.sfl.americantutor.security.LoginVM;
import com.sfl.americantutor.security.jwt.TokenProvider;
import com.sfl.americantutor.service.UserService;
import com.sfl.americantutor.service.dto.UserDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.Collections;

@RestController
@RequestMapping("/api")
public class UserJWTController {

    private final AuthenticationManager authenticationManager;
    private final TokenProvider tokenProvider;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthorityRepository authorityRepository;
    private final UserService userService;

    public UserJWTController(AuthenticationManager authenticationManager, TokenProvider tokenProvider, UserRepository userRepository, PasswordEncoder passwordEncoder, AuthorityRepository authorityRepository, UserService userService) {
        this.authenticationManager = authenticationManager;
        this.tokenProvider = tokenProvider;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.authorityRepository = authorityRepository;
        this.userService = userService;
    }

    @PostMapping("/authenticate")
    public ResponseEntity<JWTToken> authorize(@Valid @RequestBody LoginVM loginVM) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginVM.getEmailId(),
                        loginVM.getPassword()
                )
        );

        Long userId = userService.findIdByEmail(loginVM.getEmailId());
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = tokenProvider.generateToken(authentication, userId);
        return ResponseEntity.ok(new JWTToken(jwt));
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@Valid @RequestBody UserDTO userDTO) {
        if (userRepository.existsByEmail(userDTO.getEmail())) {
            throw new RuntimeException("Email is already taken");
        }

        ATUser atUser = new ATUser();
        atUser.setFirstName(userDTO.getFirstName());
        atUser.setLastName(userDTO.getLastName());
        atUser.setEmail(userDTO.getEmail());
        atUser.setPassword(passwordEncoder.encode(userDTO.getPassword()));

        ATAuthority userRole = authorityRepository.findByName(AuthoritiesConstants.USER)
                .orElseThrow(() -> new RuntimeException("User Role not set."));

        atUser.setAtAuthorities(Collections.singleton(userRole));
        atUser.setActivated(true);

        ATUser result = userRepository.save(atUser);

        URI location = ServletUriComponentsBuilder
                .fromCurrentContextPath().path("/api/users")
                .buildAndExpand(result.getEmail()).toUri();

        return ResponseEntity.created(location).body(result);
    }

    /**
     * Object to return as body in JWT Authentication.
     */
    static class JWTToken {

        private String idToken;

        JWTToken(String idToken) {
            this.idToken = idToken;
        }

        @JsonProperty("id_token")
        String getIdToken() {
            return idToken;
        }

        void setIdToken(String idToken) {
            this.idToken = idToken;
        }
    }
}
