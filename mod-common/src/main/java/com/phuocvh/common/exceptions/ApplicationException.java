package com.phuocvh.common.exceptions;

import com.phuocvh.common.exceptions.policies.ApplicationExceptionPolicy;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApplicationException extends RuntimeException implements ApplicationExceptionPolicy {
  protected final String code;
  protected final String message;

  public ApplicationException(ApplicationExceptionReason reason) {
    this.code = reason.getCode();
    this.message = reason.getMessage();
  }

  public ApplicationException(final ApplicationExceptionReason reason, final Object... parameters) {
    if (parameters != null) {
      this.message = String.format(reason.getMessage(), parameters);
    } else {
      this.message = reason.getMessage();
    }

    this.code = reason.getCode();
  }
}
