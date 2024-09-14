package com.phuocvh.common.exceptions;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

  @Value("{mode.debug}")
  private Boolean debug;

  @ExceptionHandler(ApiException.class)
  public ResponseEntity<ApiError> handleApiException(ApiException e) {
    ApiError apiError = e.getApiError();
    if (debug) {
      apiError = apiError.withDebug(e);
    }
    return ResponseEntity.status(apiError.getStatus()).body(apiError);
  }

  @ExceptionHandler(Exception.class)
  public ResponseEntity<ApiError> handleInternalServerException(Exception e) {
    ApiError apiError = ApiErrorBuilder.build();
    if (debug) {
      apiError = apiError.withDebug(e);
    }
    return ResponseEntity.status(apiError.getStatus()).body(apiError);
  }
}
