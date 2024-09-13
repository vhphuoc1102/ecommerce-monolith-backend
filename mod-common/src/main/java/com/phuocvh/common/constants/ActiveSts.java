package com.phuocvh.common.constants;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ActiveSts {
  ACTIVE(1),
  INACTIVE(0);

  private final int value;
}
