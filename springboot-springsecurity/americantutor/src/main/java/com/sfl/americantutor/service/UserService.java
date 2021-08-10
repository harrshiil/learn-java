package com.sfl.americantutor.service;

import com.sfl.americantutor.domain.ATUser;
import com.sfl.americantutor.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Long findIdByEmail(String email) {
        return userRepository.findByEmail(email)
                .map(ATUser::getId)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }
}
