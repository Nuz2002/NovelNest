package org.ucentralasia.NovelNest.controller;


import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.ucentralasia.NovelNest.dto.*;
import org.ucentralasia.NovelNest.model.user.PasswordResetToken;
import org.ucentralasia.NovelNest.model.user.User;
import org.ucentralasia.NovelNest.repository.PasswordResetTokenRepository;
import org.ucentralasia.NovelNest.repository.UserRepository;
import org.ucentralasia.NovelNest.service.AuthService;
import org.ucentralasia.NovelNest.service.CustomUserDetailsService;
import org.ucentralasia.NovelNest.service.EmailService;
import org.ucentralasia.NovelNest.service.JwtUtil;
import org.ucentralasia.NovelNest.model.user.VerificationToken;
import org.ucentralasia.NovelNest.repository.VerificationTokenRepository;

import java.time.LocalDateTime;
import java.util.UUID;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<String> register(@Valid @RequestBody RegisterRequest request) {
        return authService.register(request);
    }


    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@Valid @RequestBody LoginRequest request) throws Exception {
        return authService.login(request);
    }

    @GetMapping("/verify")
    public ResponseEntity<String> verifyEmail(@RequestParam("token") String token) {
        return authService.verifyEmail(token);
    }

    // Forgot password post endpoint
    @PostMapping("/forgot-password")
    public ResponseEntity<String> forgotPassword(@Valid @RequestBody ForgetPasswordRequest request) {
         return authService.forgotPassword(request);
    }

    // Endpoint to handle password resetting (change the users password in the database)
    @PostMapping("/reset-password")
    public ResponseEntity<String> resetPassword(@Valid @RequestBody ResetPasswordRequest request) {
        return authService.resetPassword(request);
    }
}
