package com.phuocvh.common.constants;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum SendSts {
  NOT_SEND(0),
  SEND(1);

  private final int value;
}
