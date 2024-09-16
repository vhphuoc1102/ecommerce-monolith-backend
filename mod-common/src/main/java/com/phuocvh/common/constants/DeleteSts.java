package com.phuocvh.common.constants;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum DeleteSts {
  NOT_DELETED(0),
  DELETED(1);

  private final int value;
}
