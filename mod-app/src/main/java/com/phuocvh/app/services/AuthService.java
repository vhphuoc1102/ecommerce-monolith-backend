package com.phuocvh.app.services;

import com.phuocvh.app.dtos.auth.LoginRequest;
import com.phuocvh.app.dtos.auth.LoginResponse;
import com.phuocvh.app.dtos.auth.SignupRequest;
import com.phuocvh.app.repositories.MmMemberLevelRepository;
import com.phuocvh.app.repositories.UmMemberCredentialRepository;
import com.phuocvh.app.repositories.UmMemberRepository;
import com.phuocvh.common.constants.LoginType;
import com.phuocvh.common.exceptions.BusinessException;
import com.phuocvh.common.exceptions.BusinessExceptionReason;
import com.phuocvh.common.models.entities.mms.MmMemberLevel;
import com.phuocvh.common.models.entities.ums.UmMember;
import com.phuocvh.common.models.entities.ums.UmMemberCredential;
import com.phuocvh.common.utils.DataUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
  private final UmMemberCredentialRepository umMemberCredentialRepository;
  private final JwtService jwtService;
  private final MmMemberLevelRepository mmMemberLevelRepository;
  private final UmMemberRepository umMemberRepository;
  private final AuthenticationManager authenticationManager;
  private final PasswordEncoder passwordEncoder;

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

    if (!passwordEncoder.matches(loginRequest.password(), umMemberCredential.getPassword())) {
      throw new BusinessException(BusinessExceptionReason.USER_NOT_FOUND, "password", "******");
    }

    String token = jwtService.generateToken(umMemberCredential);
    Long expireIn = jwtService.getExpirationTime();

    return new LoginResponse(token, expireIn);
  }

  public void signup(SignupRequest signupRequest) {
    umMemberCredentialRepository
        .findByEmail(signupRequest.email())
        .ifPresentOrElse(
            credential -> {
              if (LoginType.DATABASE.getValue().equals(credential.getType())) {
                throw new BusinessException(BusinessExceptionReason.EMAIL_EXISTED);
              }
              credential.setType(credential.getType() + "-" + LoginType.DATABASE.getValue());
              credential.setPassword(passwordEncoder.encode(signupRequest.password()));
              umMemberCredentialRepository.save(credential);
            },
            () -> {
              UmMemberCredential newCredential =
                  UmMemberCredential.builder()
                      .email(signupRequest.email())
                      .password(passwordEncoder.encode(signupRequest.password()))
                      .type(LoginType.DATABASE.getValue())
                      .build();
              MmMemberLevel memberLevel =
                  mmMemberLevelRepository.findAll(Sort.by(Sort.Direction.DESC, "sortOrder")).get(0);
              UmMember member = new UmMember();
              member.setMemberLevelId(memberLevel.getId());
              member.setUmMemberCredential(newCredential);
              umMemberRepository.save(member);
            });
  }
}
