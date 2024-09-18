package com.phuocvh.common.constants;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum PromoType {
  NORMAL(0),
  PROMO(1),
  MEMBER(2),
  LADDER(3),
  DISCOUNT(4);
  private final int value;
}
