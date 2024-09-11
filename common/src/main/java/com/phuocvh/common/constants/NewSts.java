package com.phuocvh.common.constants;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum NewSts {
  OLD(0),
  LIKELY_NEW(1),
  NEW(2);

  private final int value;
}
