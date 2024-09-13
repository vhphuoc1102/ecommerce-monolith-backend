package com.phuocvh.common.constants;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum NavSts {
  DISPLAY(1),
  NOT_DISPLAY(0);

  private final int value;
}
