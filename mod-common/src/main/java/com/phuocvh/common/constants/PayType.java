package com.phuocvh.common.constants;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum PayType {
  NOT_PAID(0),
  BANK(1),
  MOMO(2),
  ZALO_PAY(3),
  VIETTEL_PAY(4);

  private final int value;
}
