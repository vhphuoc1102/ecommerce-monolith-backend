package com.phuocvh.app.services;

import com.phuocvh.app.dtos.LoginRequest;
import com.phuocvh.app.dtos.LoginResponse;
import com.phuocvh.app.repositories.UmMemberCredentialRepository;
import com.phuocvh.common.exceptions.BusinessException;
import com.phuocvh.common.exceptions.BusinessExceptionReason;
import com.phuocvh.common.models.entities.ums.UmMemberCredential;
import com.phuocvh.common.utils.DataUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
  private final UmMemberCredentialRepository umMemberCredentialRepository;
  private final AuthenticationManager authenticationManager;
  private final PasswordEncoder passwordEncoder;
  private final JwtService jwtService;

  public LoginResponse login(LoginRequest loginRequest) {
    UmMemberCredential umMemberCredential;
    if (DataUtils.isEmail(loginRequest.emailOrPhone())) {
      umMemberCredential =
          umMemberCredentialRepository
              .findByEmail(loginRequest.emailOrPhone())
              .orElseThrow(
                  () ->
                      new BusinessException(
                          BusinessExceptionReason.USER_NOT_FOUND,
                          "email",
                          loginRequest.emailOrPhone()));
    } else if (DataUtils.isPhone(loginRequest.emailOrPhone())) {
      umMemberCredential =
          umMemberCredentialRepository
              .findByPhone(loginRequest.emailOrPhone())
              .orElseThrow(
                  () ->
                      new BusinessException(
                          BusinessExceptionReason.USER_NOT_FOUND,
                          "phone",
                          loginRequest.emailOrPhone()));
    } else {
      throw new BusinessException(BusinessExceptionReason.INVALID_EMAIL_OR_PHONE);
    }

    String token = jwtService.generateToken(umMemberCredential);
    Long expireIn = jwtService.getExpirationTime();

    return new LoginResponse(token, expireIn);
  }
}
