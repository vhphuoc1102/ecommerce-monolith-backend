package com.phuocvh.common.constants;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum PromoType {
  NORMAL(0),
  MEMBER(1),
  LADDER(2),
  REDUCE(3),
  FLASH_SALE(4);
  private final int value;
}
