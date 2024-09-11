package com.phuocvh.common.constants;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ProductSubject {
  NEW_ARRIVAL(0),
  BEST_SELLER(1),
  RECOMMENDED(2);

  private final int value;
}
