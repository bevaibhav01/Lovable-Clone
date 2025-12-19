package com.project.lovable_clone.controllers;

import com.project.lovable_clone.dto.auth.*;
import com.project.lovable_clone.service.AuthService;
import com.project.lovable_clone.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("api/auth")
public class AuthControllers {

    private AuthService authService;
    private UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<AuthResponse> signUp(SignUpRequest request){
        return ResponseEntity.ok(authService.signup(request));
    }

    @PostMapping("/login")
    public  ResponseEntity<AuthResponse> login(LoginRequest request){
        return ResponseEntity.ok(authService.login(request));
    }

    @GetMapping("/me")
    public ResponseEntity<UserProfileResponse> getProfile(){
        Long userId=1L;
        return ResponseEntity.ok(userService.getProfile(userId));
    }






}
