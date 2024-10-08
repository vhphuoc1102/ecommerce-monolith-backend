package com.phuocvh.common.constants;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum LoginType {
  DATABASE("0"),
  GOOGLE("1"),
  FACEBOOK("2");
  private final String value;
}
