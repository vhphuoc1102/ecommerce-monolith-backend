package com.phuocvh.common.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApiException extends RuntimeException {
  private final ApiError apiError;

  private String message;

  public ApiException(String message) {
    super();
    this.message = message;
    this.apiError = ApiErrorBuilder.build();
  }

  public ApiException(ApiError apiError) {
    super();
    this.apiError = apiError;
  }
}
