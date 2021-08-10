package com.sfl.americantutor.security;

import com.sfl.americantutor.domain.ATUser;
import com.sfl.americantutor.repository.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component("userDetailsService")
public class DomainUserDetailsService implements UserDetailsService {

    private static UserRepository userRepository;

    public DomainUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String usernameOrEmail)
            throws UsernameNotFoundException {
        return userRepository.findByEmail(usernameOrEmail)
                .map(this::createSpringSecurityUser)
                .orElseThrow(() ->
                        new UsernameNotFoundException("User not found with username or email : " + usernameOrEmail)
                );
    }

    private User createSpringSecurityUser(ATUser user) {
        if (!user.isActivated()) {
            throw new RuntimeException("Your account is not active. Please contact administrator.");
        }

        List<GrantedAuthority> grantedAuthorities = user.getAtAuthorities().stream()
                .map(authority -> new SimpleGrantedAuthority(authority.getName()))
                .collect(Collectors.toList());
        return new User(user.getEmail(),
                user.getPassword(),
                grantedAuthorities);
    }

    /**
     * Returns the current logged in user
     *
     * @return current logged in user
     */
    public static Optional<ATUser> getCurrentUser() {
        Optional<String> currentLoggedInUserEmail = SecurityUtils.getCurrentUserEmail();
        if (currentLoggedInUserEmail.isPresent()) {
            return userRepository.findByEmail(currentLoggedInUserEmail.get());
        }
        return Optional.empty();
    }
}