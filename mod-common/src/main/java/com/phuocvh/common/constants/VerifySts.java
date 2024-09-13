package com.phuocvh.common.constants;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum VerifySts {
  UNVERIFIED(0),
  VERIFIED(1),
  CANCELLED(9);

  private final int value;
}
