package com.app.greetingapp.controller;

import com.app.greetingapp.dto.AuthUserDTO;
import com.app.greetingapp.model.AuthUser;
import com.app.greetingapp.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class AuthUserController {

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@Valid @RequestBody AuthUserDTO authUserDTO) {
        try {
            authenticationService.registerUser(authUserDTO);
            return ResponseEntity.ok("User registered successfully!");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage()); // Now returns a proper 400 response
        }
    }

    @GetMapping("/user")
    public ResponseEntity<?> getUserByEmail(@RequestParam String email) {
        try {
            AuthUser user = authenticationService.getUserByEmail(email);
            return ResponseEntity.ok(user);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    //UC 10
//    @PostMapping("/login")
//    public ResponseEntity<String> loginUser(@RequestParam String email, @RequestParam String password) {
//        Optional<AuthUser> user = authenticationService.authenticateUser(email, password);
//        if (user.isPresent()) {
//            return ResponseEntity.ok("Login successful!");
//        }
//        return ResponseEntity.badRequest().body("Invalid email or password!");
//    }

    //UC 11
    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestParam String email, @RequestParam String password) {
        try {
            String token = authenticationService.loginUser(email, password);
            return ResponseEntity.ok("Bearer " + token);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
