package com.phuocvh.common.exceptions;

import com.phuocvh.common.exceptions.policies.ApplicationExceptionPolicy;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ApplicationExceptionReason implements ApplicationExceptionPolicy {
  ;
  private final String code = ApplicationExceptionReason.class.getSimpleName();
  private final String message;
}
