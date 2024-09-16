package com.phuocvh.common.utils;

public class DataUtils {
  private DataUtils() {}

  public static boolean isPhone(String emailOrPhone) {
    return emailOrPhone.matches("^\\d{10,11}$");
  }

  public static boolean isEmail(String emailOrPhone) {
    return emailOrPhone.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$");
  }
}
