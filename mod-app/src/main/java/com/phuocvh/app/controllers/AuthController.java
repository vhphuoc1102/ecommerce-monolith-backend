package com.phuocvh.app.controllers;

import com.phuocvh.app.dtos.LoginRequest;
import com.phuocvh.app.dtos.LoginResponse;
import com.phuocvh.app.dtos.SignupRequest;
import com.phuocvh.app.services.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
  private final AuthService authService;

  @PostMapping("/login")
  public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest) {
    return ResponseEntity.ok(authService.login(loginRequest));
  }

  @PostMapping("/signup")
  public void signup(@RequestBody SignupRequest signupRequest) {
    authService.signup(signupRequest);
  }
}
