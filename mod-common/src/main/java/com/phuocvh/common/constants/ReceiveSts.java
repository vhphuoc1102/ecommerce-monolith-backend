package com.phuocvh.common.constants;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ReceiveSts {
  NOT_RECEIVE(0),
  RECEIVED(1);

  private final int value;
}
