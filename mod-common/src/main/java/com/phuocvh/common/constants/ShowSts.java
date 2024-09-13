package com.phuocvh.common.constants;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ShowSts {
  HIDDEN(0),
  SHOW(1),
  ALWAYS_SHOW(2);

  private final int value;
}
