package com.phuocvh.common.constants;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ConfirmSts {
  NOT_CONFIRM(0),
  CONFIRM(1),
  DISPROVE(2);

  private final int value;
}
