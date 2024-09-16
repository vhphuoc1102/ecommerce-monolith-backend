package com.phuocvh.app.services;

import com.phuocvh.app.dtos.LoginRequest;
import com.phuocvh.app.repositories.UmMemberCredentialRepository;
import com.phuocvh.common.models.entities.ums.UmMemberCredential;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
  private final UmMemberCredentialRepository umMemberCredentialRepository;
  private final AuthenticationManager authenticationManager;
  private final PasswordEncoder passwordEncoder;

  private UmMemberCredential authenticate(LoginRequest loginRequest) {
    return null;
  }
}
