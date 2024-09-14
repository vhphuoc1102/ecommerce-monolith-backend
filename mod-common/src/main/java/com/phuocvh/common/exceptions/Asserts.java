package com.phuocvh.common.exceptions;

public class Asserts {
  public static void fail(String message) {
    throw new ApiException(message);
  }

  public static void fail(ApiError apiError) {
    throw new ApiException(apiError);
  }
}
