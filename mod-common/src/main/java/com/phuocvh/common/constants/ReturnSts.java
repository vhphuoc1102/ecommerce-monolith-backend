package com.phuocvh.common.constants;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ReturnSts {
  PENDING(0),
  RETURNING(1),
  COMPLETED(2),
  REJECTED(3);

  private final int value;
}
