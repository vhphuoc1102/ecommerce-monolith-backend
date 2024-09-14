package com.phuocvh.common.exceptions;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ApiErrorBuilder {
  @Value("{spring.application.name}")
  private static String module;

  public static ApiError build() {
    return new ApiError(module).withMessage(Message.DEFAULT);
  }

  static class Message {
    public static final String DEFAULT = "Somethings went wrong";
  }
}
