package com.project.lovable_clone.controllers;

import com.project.lovable_clone.dto.auth.*;
import com.project.lovable_clone.service.AuthService;
import com.project.lovable_clone.service.UsageService;
import com.project.lovable_clone.service.UserService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/auth")
@Getter
@RequiredArgsConstructor
public class AuthControllers {

    private final AuthService authService;
    private final UserService userService;


    @PostMapping("/signup")
    public ResponseEntity<AuthResponse> signUp(@RequestBody SignUpRequest request){
        return ResponseEntity.ok(authService.signup(request));
    }

    @PostMapping("/login")
    public  ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request){
        return ResponseEntity.ok(authService.login(request));
    }

    @GetMapping("/me")
    public ResponseEntity<UserProfileResponse> getProfile(){
        Long userId=1L;
        return ResponseEntity.ok(userService.getProfile(userId));
    }






}
