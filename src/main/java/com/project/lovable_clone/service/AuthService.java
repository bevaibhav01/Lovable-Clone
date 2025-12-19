package com.project.lovable_clone.service;

import com.project.lovable_clone.dto.auth.AuthResponse;
import com.project.lovable_clone.dto.auth.LoginRequest;
import com.project.lovable_clone.dto.auth.SignUpRequest;

public interface AuthService {
    AuthResponse signup(SignUpRequest request);

    AuthResponse login(LoginRequest request);
}
