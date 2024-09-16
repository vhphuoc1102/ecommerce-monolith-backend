package com.phuocvh.app.config;

import com.phuocvh.app.repositories.UmMemberCredentialRepository;
import com.phuocvh.common.exceptions.BusinessException;
import com.phuocvh.common.exceptions.BusinessExceptionReason;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@RequiredArgsConstructor
public class AppConfig {
  private final UmMemberCredentialRepository umMemberCredentialRepository;

  @Bean
  UserDetailsService userDetailsService() {
    return emailOrPhone -> {
      if (isPhone(emailOrPhone)) {
        return umMemberCredentialRepository
            .findByPhone(emailOrPhone)
            .orElseThrow(
                () ->
                    new BusinessException(
                        BusinessExceptionReason.USER_NOT_FOUND, "phone", emailOrPhone));

      } else if (isEmail(emailOrPhone)) {
        return umMemberCredentialRepository
            .findByEmail(emailOrPhone)
            .orElseThrow(
                () ->
                    new BusinessException(
                        BusinessExceptionReason.USER_NOT_FOUND, "email", emailOrPhone));
      } else {
        throw new BusinessException(BusinessExceptionReason.INVALID_EMAIL_OR_PHONE);
      }
    };
  }

  @Bean
  BCryptPasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Bean
  public AuthenticationManager authenticationManager(AuthenticationConfiguration config)
      throws Exception {
    return config.getAuthenticationManager();
  }

  @Bean
  AuthenticationProvider authenticationProvider() {
    DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
    authProvider.setUserDetailsService(userDetailsService());
    authProvider.setPasswordEncoder(passwordEncoder());

    return authProvider;
  }

  private boolean isPhone(String phoneOrEmail) {
    return phoneOrEmail.matches("^\\d{10,11}$");
  }

  private boolean isEmail(String phoneOrEmail) {
    return phoneOrEmail.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$");
  }
}
