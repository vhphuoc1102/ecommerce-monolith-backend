package com.phuocvh.common.exceptions.dtos;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class ErrorResponseBuilder {
  @Value("${spring.application.name}")
  private static String module;

  @Value("${mode.debug:true}")
  private static Boolean debug;

  private ErrorResponseBuilder() {}

  public static ErrorResponse build(
      final String code, final String message, final String debugMessage, final HttpStatus status) {
    return build(code, message, status, debugMessage, null);
  }

  public static ErrorResponse build(
      final String code,
      final String message,
      final HttpStatus status,
      final String debugMessage,
      final List<InvalidParam> invalidParams) {
    final ErrorResponse errorResponse = new ErrorResponse();
    errorResponse.setModule(module);
    errorResponse.setCode(code);
    errorResponse.setMessage(message);
    if (debug) {
      errorResponse.setDebug(debugMessage);
    }
    if (!Objects.isNull(status)) {
      errorResponse.setHttpStatus(status.value());
    }
    errorResponse.setTimestamp(LocalDateTime.now());
    if (!CollectionUtils.isEmpty(invalidParams)) {
      errorResponse.setInvalidParams(invalidParams);
    }
    return errorResponse;
  }
}
