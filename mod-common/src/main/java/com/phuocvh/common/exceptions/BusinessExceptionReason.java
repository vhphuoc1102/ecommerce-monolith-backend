package com.phuocvh.common.exceptions;

import com.phuocvh.common.exceptions.policies.BusinessExceptionPolicy;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum BusinessExceptionReason implements BusinessExceptionPolicy {
  ENTITY_NOT_FOUND("Not found %s entity with id: %s", HttpStatus.NOT_FOUND),
  USER_NOT_FOUND("User not found with %s: %s", HttpStatus.BAD_REQUEST),
  INVALID_EMAIL("Invalid email", HttpStatus.BAD_REQUEST),
  EMAIL_EXISTED("Email existed", HttpStatus.BAD_REQUEST),
  INVALID_EMAIL_OR_PHONE("Invalid email or phone", HttpStatus.BAD_REQUEST);

  private final String code = BusinessExceptionReason.class.getSimpleName();
  private final String message;
  private final HttpStatus httpStatus;
}
