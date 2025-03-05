package com.app.greetingapp.service;

import com.app.greetingapp.dto.AuthUserDTO;
import com.app.greetingapp.model.AuthUser;
import com.app.greetingapp.repository.AuthUserRepository;
import com.app.greetingapp.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

//UC 9
@Service
public class AuthenticationService {
    @Autowired
    private AuthUserRepository authUserRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtil jwtUtil;

    public AuthUser registerUser(AuthUserDTO authUserDTO) {
        if (authUserRepository.findByEmail(authUserDTO.getEmail()).isPresent()) {
            throw new IllegalArgumentException("User with this email already exists"); // Now throws an exception
        }
        AuthUser newUser = new AuthUser();
        newUser.setFirstName(authUserDTO.getFirstName());
        newUser.setLastName(authUserDTO.getLastName());
        newUser.setEmail(authUserDTO.getEmail());
        newUser.setPassword(passwordEncoder.encode(authUserDTO.getPassword()));
        return authUserRepository.save(newUser);
    }
    public AuthUser getUserByEmail(String email) {
        return authUserRepository.findByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException("User not found with email: " + email));
    }

    //UC 10
    public Optional<AuthUser> authenticateUser(String email, String password) {
        Optional<AuthUser> user = authUserRepository.findByEmail(email);
        if (user.isPresent() && passwordEncoder.matches(password, user.get().getPassword())) {
            return user;
        }
        return Optional.empty();
    }

    //UC 11
    public String loginUser(String email, String password) {
        Optional<AuthUser> user = authUserRepository.findByEmail(email);
        if (user.isPresent() && passwordEncoder.matches(password, user.get().getPassword())) {
            return jwtUtil.generateToken(email);
        }
        throw new IllegalArgumentException("Invalid email or password");
    }
}