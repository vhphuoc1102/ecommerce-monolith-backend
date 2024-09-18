package com.phuocvh.common.constants;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ActiveSts {
  ACTIVE(1, true),
  INACTIVE(0, false);

  private final int value;
  private final Boolean isActive;
}
